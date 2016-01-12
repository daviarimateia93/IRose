package irose.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MaskFormatter;

public class StringHelper
{
	public static String urlEncode(String string)
	{
		if(string != null)
		{
			try
			{
				return URLEncoder.encode(string, Constants.TEXT_CHARSET_UTF_8);
			}
			catch(UnsupportedEncodingException unsupportedEncodingException)
			{
				return null;
			}
		}
		
		return null;
	}
	
	public static String urlDecode(String string)
	{
		if(string != null)
		{
			try
			{
				return URLDecoder.decode(string, Constants.TEXT_CHARSET_UTF_8);
			}
			catch(UnsupportedEncodingException unsupportedEncodingException)
			{
				return null;
			}
		}
		
		return null;
	}
	
	public static String fixToHtml(String string)
	{
		return string == null ? null : string.trim().replace(String.valueOf(Constants.CHAR_LT), Constants.TEXT_HTML_CODE_LT).replace(String.valueOf(Constants.CHAR_GT), Constants.TEXT_HTML_CODE_GT).replace(String.valueOf(Constants.CHAR_AMP), Constants.TEXT_HTML_CODE_AMP).replace(String.valueOf(Constants.CHAR_QUOTE), Constants.TEXT_HTML_CODE_QUOTE).replace(String.valueOf(Constants.CHAR_SINGLE_QUOTE), Constants.TEXT_HTML_CODE_SINGLE_QUOTE).replace(String.valueOf(Constants.CHAR_EQUALS), Constants.TEXT_HTML_CODE_EQUALS);
	}
	
	public static String shuffle(String string)
	{
		if(string == null)
		{
			return null;
		}
		
		if(string.length() > 0)
		{
			List<Character> characters = new ArrayList<>();
			
			for(char character : string.toCharArray())
			{
				characters.add(character);
			}
			
			StringBuilder output = new StringBuilder(string.length());
			
			while(!characters.isEmpty())
			{
				output.append(characters.remove((int) (Math.random() * characters.size())));
			}
			
			return output.toString();
		}
		else
		{
			return string;
		}
	}
	
	public static String hex(byte[] stringBytes)
	{
		if(stringBytes == null)
		{
			return null;
		}
		
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < stringBytes.length; i++)
		{
			output.append(Integer.toString((stringBytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		
		return output.toString();
	}
	
	public static String onlyNumbers(String string)
	{
		if(!isNullOrEmpty(string))
		{
			return string.replaceAll(Constants.TEXT_PATTERN_NON_NUMERIC_ALL, Constants.TEXT_EMPTY);
		}
		
		return null;
	}
	
	public static String format(String string, String pattern)
	{
		if(string == null)
		{
			return null;
		}
		
		try
		{
			MaskFormatter mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			
			return mask.valueToString(string);
		}
		catch(ParseException parseException)
		{
			return string;
		}
	}
	
	public static boolean isNullOrBlank(String string)
	{
		return string != null ? string.trim().isEmpty() : true;
	}
	
	public static boolean isNullOrEmpty(String string)
	{
		return string != null ? string.isEmpty() : true;
	}
}
