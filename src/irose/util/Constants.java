package irose.util;

public class Constants
{
	// patterns
	public static final String TEXT_PATTERN_EMAIL = "^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$";
	public static final String TEXT_PATTERN_NON_NUMERIC = "[^0-9]";
	public static final String TEXT_PATTERN_NON_NUMERIC_ALL = "[^0-9]+";
	public static final String TEXT_PATTERN_NUMERIC = "[0-9]+";
	public static final String TEXT_PATTERN_NUMERIC_ALL = "[0-9]+";
	public static final String TEXT_PATTERN_CEP = "^[0-9]{8}$";
	public static final String TEXT_PATTERN_CNPJ = "^[0-9]{14}$";
	public static final String TEXT_PATTERN_CPF = "^[0-9]{11}$";
	public static final String TEXT_PATTERN_ID_ESTRANGEIRO = "^(.{5,20})$";
	public static final String TEXT_PATTERN_TELEFONE = "^([0-9]{13})|([0-9]{12})$";
	public static final String TEXT_PATTERN_INSCRICAO_MUNICIPAL = "^([0-9]{1,15})$";
	public static final String TEXT_PATTERN_CNAE = "^([0-9]{7})$";
	public static final String TEXT_PATTERN_DOT = "\\.";
	public static final String TEXT_PATTERN_BOOLEAN = "(?i)^(false|true)$";
	public static final String TEXT_PATTERN_APELIDO = "^[a-zA-Z0-9\\.\\-\\_]+$";
	public static final String TEXT_PATTERN_HEX = "^[0-9A-Fa-f]+$";
	public static final String TEXT_PATTERN_NVE = "^[A-Z]{2}[0-9]{4}$";
	public static final String TEXT_PATTERN_NCM = "^([0-9]{8})|([0]{2})$";
	public static final String TEXT_PATTERN_EX_TIPI = "^[0-9]{2,3}$";
	public static final String TEXT_PATTERN_EAN = "^([0-9]{8})|([0-9]{12})|([0-9]{13})|([0-9]{14})$";
	public static final String TEXT_PATTERN_CEST = "^[0-9]{7}$";
	public static final String TEXT_PATTERN_CFOP = "^[0-9]{4}$";
	public static final String TEXT_PATTERN_NUMERO_FCI = "^[A-F0-9\\-]{36}$";
	
	// http headers
	public static final String TEXT_HEADER_USER_CREDENTIALS = "User-Credentials";
	public static final String TEXT_HEADER_REFERER = "Referer";
	public static final String TEXT_HEADER_ACCEPT_CHARSET = "Accept-Charset";
	public static final String TEXT_HEADER_CONTENT_TYPE = "Content-Type";
	public static final String TEXT_HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public static final String TEXT_HEADER_CACHE_CONTROL = "Cache-Control";
	public static final String TEXT_HEADER_PRAGMA = "Pragma";
	
	// char numbers
	public static final char CHAR_0 = '0';
	public static final char CHAR_1 = '1';
	public static final char CHAR_2 = '2';
	public static final char CHAR_3 = '3';
	public static final char CHAR_4 = '4';
	public static final char CHAR_5 = '5';
	public static final char CHAR_6 = '6';
	public static final char CHAR_7 = '7';
	public static final char CHAR_8 = '8';
	public static final char CHAR_9 = '9';
	
	// char symbols
	public static final char CHAR_DOT = '.';
	public static final char CHAR_EQUALS = '=';
	public static final char CHAR_SEMICOLON = ';';
	public static final char CHAR_SLASH = '/';
	public static final char CHAR_QUESTION_MARK = '?';
	public static final char CHAR_LT = '<';
	public static final char CHAR_GT = '>';
	public static final char CHAR_AMP = '&';
	public static final char CHAR_QUOTE = '"';
	public static final char CHAR_SINGLE_QUOTE = '\'';
	public static final char CHAR_2_DOT = ':';
	public static final char CHAR_SPACE = ' ';
	public static final char CHAR_UNDERLINE = '_';
	public static final char CHAR_DASH = '-';
	
	// int numbers
	public static final int INT_0 = 0;
	
	// string html codes
	public static final String TEXT_HTML_CODE_LT = "&lt;";
	public static final String TEXT_HTML_CODE_GT = "&gt;";
	public static final String TEXT_HTML_CODE_AMP = "&amp;;";
	public static final String TEXT_HTML_CODE_QUOTE = "&quot;";
	public static final String TEXT_HTML_CODE_SINGLE_QUOTE = "&#039;";
	public static final String TEXT_HTML_CODE_EQUALS = "&#61;";
	
	// content types
	public static final String TEXT_CONTENT_TYPE_IMAGE_JPEG = "IMAGE/JPEG";
	public static final String TEXT_CONTENT_TYPE_IMAGE_JPG = "IMAGE/JPG";
	public static final String TEXT_CONTENT_TYPE_IMAGE_JPE = "IMAGE/JPE";
	public static final String TEXT_CONTENT_TYPE_IMAGE_GIF = "IMAGE/GIF";
	public static final String TEXT_CONTENT_TYPE_IMAGE_PNG = "IMAGE/PNG";
	public static final String TEXT_CONTENT_TYPE_IMAGE_BMP = "IMAGE/BMP";
	public static final String TEXT_CONTENT_TYPE_APLICATION_PDF = "application/pdf";
	public static final String TEXT_CONTENT_TYPE_TEXT_HTML = "text/html";
	
	// charset
	public static final String TEXT_CHARSET_UTF_8 = "UTF-8";
	public static final String TEXT_CHARSET_ISO_8859_1 = "ISO-8859-1";
	
	// algorithm
	public static final String TEXT_ALGORITHM_SHA_512 = "SHA-512";
	public static final String TEXT_ALGORITHM_RSA = "RSA";
	
	// keystore instance type
	public static final String TEXT_KEYSTORE_INSTANCE_TYPE_PKCS12 = "PKCS12";
	
	// certificate type
	public static final String TEXT_CERTIFICATE_TYPE_X509 = "X.509";
	
	// countries codes
	public static final String TEXT_COUNTRY_BRAZIL = "BR";
	
	// empty
	public static final String TEXT_EMPTY = "";
	
	// others
	public static final String TEXT_AUTO_GENERATED = "Gerado automaticamente";
}
