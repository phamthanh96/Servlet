/**
 *Copyright(C) Luvina
 *Common.java, Oct 7, 2019, Pham Thanh
 */
package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;


/**
 * @author Pham Thanh
 *
 */
public class Common {
	/**
	 * Phương thức đọc file properties 
	 * @param propertyName tên của file sẽ đọc
	 * @return trả về Object Properties của file đã đọc
	 * @throws IOException khi không đọc được file properties
	 */
	public Properties loadProperties(String propertyName) throws IOException {
		Properties properties = new Properties();
		 
		try (InputStream input =Common.class.getClassLoader().getResourceAsStream(propertyName)) {
			properties.load(input);
		} catch (IOException e) { 
			System.err.println(" Không đọc được file properties");
			throw new IOException();
		}
		return properties;
	}

	/**
	 * Phương thức trả về errorMessage
	 * @param errorCode nhận mã lỗi
	 * @return nội dung mã lỗi
	 */
	public String getErrorMessage(String errorCode) {
		String errorMessage = "";
		
		try {
			Properties prop = loadProperties("error.properties");
			errorMessage = prop.getProperty(errorCode);
		} catch (IOException e) {	
			System.err.println(e.getMessage());
		}
		return errorMessage;
	}
	/**
	 * Phương thức chuyển các kí tự đặc biệt thành mã HTML
	 * @param value giá trị cần endcode
	 * @return String Chuỗi sau khi endcode
	 */
	public String encodeHtml(String value) {
		return value.replaceAll("&", "&amp;")
			    .replaceAll("\"", "&quot;")
			    .replaceAll("\'", "&#x27;")
			    .replaceAll("/", "&#x2F;")
			    .replaceAll("<", "&lt;")
			    .replaceAll(">", "&gt;");
	}
	public String validateWhiteCard(String value) {
		return value.replace("!", "!!").replace("%", "!%").replace("_", "!_").replace("[", "![");
	}
}
