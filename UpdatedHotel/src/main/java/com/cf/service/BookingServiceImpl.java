package com.cf.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.cf.GenerateQRCode;
import com.cf.exceptions.ResourceNotFoundException;
import com.cf.model.Booking;
import com.cf.repository.IBookingDao;
import com.google.zxing.WriterException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BookingServiceImpl
{
	
	@Autowired
	private IBookingDao bookingDao;
	@Autowired 
	private EmailService email;
	
	/*******************************************************************************************************
	 - Function Name	:	bookingHotel(Booking booking)
	 - Input Parameters	:	booking 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	Booking
	 * @throws IOException 
	 * @throws WriterException 
	 ********************************************************************************************************/
	public Booking bookingHotel(Booking booking) throws WriterException, IOException
	{
		Booking booking1=new Booking();
		booking1.setAmount(booking.getAmount());
		booking1.setBookingId(booking.getBookingId());
		booking1.setHotelName(booking.getHotelName());
		booking1.setModeOfPayment(booking.getModeOfPayment());
		booking1.setRoomNumber(booking.getRoomNumber());
		booking1.setUser(booking.getUser());
		booking1.setBookingDate(LocalDate.now());
		booking1.setFromDate(booking.getFromDate());
		booking1.setToDate(booking.getToDate());
		booking1.setEmail(booking.getEmail());
		
		LocalDate presentDate=LocalDate.now();
		LocalDate pastDate=presentDate.minusDays(1);
		
		LocalDate futureDate=presentDate.plusDays(6);
		LocalDate fromDate=booking.getFromDate();
		LocalDate plus5FromDate=fromDate.plusDays(6);
		LocalDate toDate=booking.getToDate();
		
//		System.out.println(presentDate);
//		System.out.println(futureDate);
		if(fromDate.isAfter(pastDate)&&fromDate.isBefore(futureDate)&&toDate.isAfter(fromDate)&&toDate.isBefore(plus5FromDate))
		{
			Booking b=bookingDao.save(booking1);
//			System.out.println(b);
			
			/***      QR CODE GENEREATOR     ****/
			String link="m.paytm.me";
			String qrCodeText = link;//"ROOM NUMER = "+b.getRoomNumber()+"\n AMOUNT PAID = "+b.getAmount()+"\n BOOKED DATE = "+b.getBookingDate()+"\n CECK IN = "+b.getFromDate()+"\n CHECK OUT = "+b.getToDate();
		
			String filePath = "./src/main/resources/qrcodes/"+b.getBookingId()+".png";
			int size = 125;
			String fileType = "png";
			File qrFile = new File(filePath);
			File file= GenerateQRCode.createQRImage(qrFile, qrCodeText, size, fileType);
			System.out.println("DONE");
			
			/*******  --------------------------    *******/
			
			/*******   EMAIL SENDER   *******/
			
			String s="Bokked room at "+b.getHotelName()+" and your room number is "+b.getRoomNumber()+ "\n PLEASE SHOW THE QRCODE TO RECIOPTIONLIST";
//			
//			email.sendSimpleMessage(b.getEmail(), "Booking",s);
//
			String location="F:\\KISHORE\\JAVA PROGRAMS\\WorkSpace\\UpdatedHotel\\src\\main\\resources\\qrcodes\\"+b.getBookingId()+".png";
			FileSystemResource Attachement = new FileSystemResource(location);

			email.sendMail(b.getEmail(), "Booking", s,Attachement);
			
			/*** ----------   *****/
			
//			System.out.println(b);
			log.info("Booking Successfull");
			return b;
		}
		else
		{
			log.error("Entered Date was past Date or You can Book Hotel for Maximum 5 Days only");
			throw new ResourceNotFoundException("Entered Date was past Date or You can Book Hotel for Maximum 5 Days only");
//			System.out.println("Wrong");
		}
		
		
//		bookingDao.save(booking1);
//		log.info("Department Added");
	}
	
	/*******************************************************************************************************
	 - Function Name	:	DeleteAllBooking()
	 - Input Parameters	:	 
	 - Return Type		:	void
	 - Throws			:  	ResourceNotFoundException
	 - Author			:	KISHOREKUMAR
	 - Description		:	DeleteAllBooking
	 ********************************************************************************************************/
	public void DeleteAllBooking()
	{
		bookingDao.deleteAll();
	}
}
