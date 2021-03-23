package com.naveen.project.accountservice.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;



@Component
public class AppHelper {

	//private static final Logger logger = Logger.getLogger(AppHelper.class);

	private static boolean checkMessageProp = true;
	private static HashMap<String, String> allMessagePropMap;
	private static HashMap<String, String> allMessagePropMapFr;
    

	/*
	 * @Value("${smtp.server}") private String serverURL;
	 * 
	 * @Value("${smtp.port}") private String port;
	 * 
	 * @Value("${smtp.username}") private String name;
	 * 
	 * @Value("${smtp.password}") private String pwd;
	 * 
	 * @Value("${smtp.mailId}") private String mailId;
	 */



	/*
	 * public static String generateRandomHexToken(int byteLength) {
	 * logger.info("In AppHelper.generateRandomHexToken"); SecureRandom secureRandom
	 * = new SecureRandom(); byte[] token = new byte[byteLength];
	 * secureRandom.nextBytes(token);
	 * logger.info("Exit AppHelper.generateRandomHexToken"); return new
	 * BigInteger(1, token).toString(16); //hex encoding }
	 */
	
	/*
	 * public byte[] getSalt() throws NoSuchAlgorithmException {
	 * logger.info("In AppHelper.getSalt"); SecureRandom sr =
	 * SecureRandom.getInstance("SHA1PRNG"); byte[] salt = new byte[16];
	 * sr.nextBytes(salt); logger.info("Exit AppHelper.getSalt"); return salt; }
	 */

	/*
	 * public String encodePassword(String passwordToHash, String language) throws
	 * AuthorizeException { logger.info("In AppHelper.encodePassword"); //String
	 * generatedPassword = null; try { MessageDigest md =
	 * MessageDigest.getInstance("SHA-256"); byte[] bytes =
	 * md.digest(passwordToHash.getBytes());
	 * logger.info("Exit AppHelper.encodePassword"); return new BigInteger(1,
	 * bytes).toString(16); } catch (Exception ex) {
	 * logger.error("Exception AppHelper.encodePassword" +ex); throw new
	 * AuthorizeException(String.format(getMessagePropValue(MessageConstants.
	 * PASSWORD_GENERATION_OR_ENCODE_FAIL_ERROR_MSG, language)),
	 * MessageConstants.PASSWORD_GENERATION_OR_ENCODE_FAIL_ERROR_MSG, language); }
	 * //return generatedPassword; }
	 */

	public Date currentDateTime() {
		//logger.info("In AppHelper.currentDateTime");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		try {
			df.format(date);
		} catch (Exception ex) {
			//logger.error("Exception AppHelper.currentDateTime" +ex);
			ex.printStackTrace();
		}
		//logger.info("Exit AppHelper.currentDateTime");
		return date;
	}

	public String getMessagePropValue(String propName, String lang) {
		//logger.info("In AppHelper.getMessagePropValue");
		if (checkMessageProp || (null != allMessagePropMap && null != allMessagePropMapFr
				&& !allMessagePropMap.isEmpty() && !allMessagePropMapFr.isEmpty())) {
			allMessagePropMap = new HashMap<String, String>();
			allMessagePropMapFr = new HashMap<String, String>();

			ResourceBundle rb = ResourceBundle.getBundle("messages_en");
			Enumeration<String> keys = rb.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = rb.getString(key);
				allMessagePropMap.put(key, value);
			}

			ResourceBundle rbFr = ResourceBundle.getBundle("messages_fr");
			Enumeration<String> keysFr = rbFr.getKeys();
			while (keysFr.hasMoreElements()) {
				String key = keysFr.nextElement();
				String value = rbFr.getString(key);
				allMessagePropMapFr.put(key, value);
			}
			checkMessageProp = false;

			if (null != lang && lang.equalsIgnoreCase("en")) {
				String message = allMessagePropMap.get(propName);
				if (message == null)
					message = allMessagePropMap.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
				//logger.info("Exit AppHelper.getMessagePropValue");
				return message;
			} else if (null != lang && lang.equalsIgnoreCase("fr")) {
				String message = allMessagePropMapFr.get(propName);
				if (message == null)
					message = allMessagePropMapFr.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
				//logger.info("Exit AppHelper.getMessagePropValue");
				return message;
			} else {
				//logger.info("Exit AppHelper.getMessagePropValue");
				return allMessagePropMap.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
			}
		} else {

			if (null != lang && lang.equalsIgnoreCase("en")) {
				String message = allMessagePropMap.get(propName);
				if (message == null)
					message = allMessagePropMap.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
				//logger.info("Exit AppHelper.getMessagePropValue");
				return message;
			} else if (null != lang && lang.equalsIgnoreCase("fr")) {
				String message = allMessagePropMapFr.get(propName);
				if (message == null)
					message = allMessagePropMapFr.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
				//logger.info("Exit AppHelper.getMessagePropValue");
				return message;
			} else {
				//logger.info("Exit AppHelper.getMessagePropValue");
				return allMessagePropMap.get(MessageConstants.MESSAGE_CODE_NOT_FOUND);
			}
		}
	}



	
	/*
	 * public Date convertStringToDate(String stringDate) {
	 * logger.info("In AppHelper.stringToUtilDate"); if (null == stringDate ||
	 * "".equals(stringDate)) { return null; } SimpleDateFormat df = new
	 * SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH); Date date = null;
	 * System.out.println("date " + stringDate); if (stringDate == null ||
	 * "".equals(stringDate) || "null".equals(stringDate)) {
	 * logger.debug("stringToUtilDate -- : Date Is null");
	 * logger.info("Exit AppHelper.stringToUtilDate"); return null; } try { date =
	 * df.parse(stringDate); } catch (Exception ex) {
	 * logger.error("Exception AppHelper.stringToUtilDate" +ex);
	 * ex.printStackTrace(); logger.error("stringToUtilDate -- : " + ex); }
	 * logger.info("Exit AppHelper.stringToUtilDate"); return date; } public String
	 * getIpaddress(HttpServletRequest request) {
	 * logger.info("In AppHelper.getIpaddress"); String ipAddress =
	 * request.getHeader("X-FORWARDED-FOR"); if (ipAddress == null) { ipAddress =
	 * request.getRemoteAddr(); } logger.info("Exit AppHelper.getIpaddress"); return
	 * ipAddress; } public String getPropValue(String propName,String language) {
	 */
	/*
	 * logger.info("In AppHelper.getPropValue"); // AppPropertiesEntity appParam =
	 * null; try { // appParam =
	 * parameterRepository.findByPropNameAndAuthStatus(propName,AdminConstants.
	 * AUTH_STATUS); } catch(Exception ex) { //
	 * logger.error("Exception AppHelper.getPropValue" +ex); ex.printStackTrace();
	 * System.out.println(ex.getLocalizedMessage()); }
	 * logger.info("Exit AppHelper.getPropValue"); return appParam.getPropValue();
	 * 
	 * }
	 */
	 
	 

}
