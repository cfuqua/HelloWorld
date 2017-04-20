package mil.dtic.common.utility;

/**
 * @author CFuqua
 *
 *         IADB Constants and shared formatting methods
 */
public class Constants {

    public final static String LOG_CONTEXT = "interag";

    public final static String EMPTY_STRING = "";
    public final static String NEW_LINE = "\n";
    public final static char HYPHEN = '-';
    public final static String NULL = "NULL";
    public final static char SPACE = ' ';
    public final static char SINGLE_QUOTE = '\'';
    public final static char DOUBLE_QUOTE = '"';
    public final static char LEFT_SQUARE_BRACKET = '[';
    public final static char RIGHT_SQUARE_BRACKET = ']';
    public final static char lEFT_PAREN = '(';
    public final static char RIGHT_PAREN = ')';

    // Identifies the name of the app (r2, p40, restapp, jobmanager, etc)
    public static final String SYSKEY_APP_NAME = "mil.dtic.ia.appName";

    // List of all app names for the project
    public static final String SYSKEY_APP_NAME_LIST = "mil.dtic.ia.appNameList";
    public static final String DEFAULT_APP_NAME_LIST = "IA, ia, iasearch";

    // Multiple instances of the same app can be deployed on the same or
    // multiple servers, this identifies the name of each instance
    public static final String SYSKEY_APP_INSTANCE_NAME = "mil.dtic.ia.appInstanceId";

    // jdbc ref cursor
    public final static String OUT_INFO_CUR = "out_info_cur";

    /**
     * quote a string with single quotes
     * 
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in single
     *            quotes
     * @return string containing input string wrapped in quotes
     */
    public final static String quoteIt(final Object p_object)
    {
        return quoteIt(p_object, SINGLE_QUOTE, SINGLE_QUOTE);
    }

    /**
     * prefix input string with single quotes (i.e., prefix 'string')
     * 
     * @param p_prefix
     *            is string to prefix string
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in single
     *            quotes
     * @return string containing prefix then input string wrapped in quotes
     */
    public final static String quoteIt(final String p_prefix, final Object p_object)
    {
        return quoteIt(p_prefix, p_object, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET);
    }

    /**
     * suffix input string with single quotes (i.e., 'string' suffix)
     * 
     * @param p_prefix
     *            is string to prefix string
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in single
     *            quotes
     * @return string containing prefix then input string wrapped in quotes
     */
    public final static String quoteSuffix(final Object p_object, final String p_sufix)
    {
        return quoteSuffix(p_object, p_sufix, SINGLE_QUOTE, SINGLE_QUOTE);
    }

    /**
     * wrap input string with specified left and right char (i.e., prefix
     * [string])
     * 
     * @param p_prefix
     *            is string to prefix string
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in left and
     *            right char
     * @param p_left_char
     *            is character
     * @param p_right_char
     *            is character
     * @return string containing prefix then input string wrapped left and right
     *         char
     */
    public final static String quoteIt(final String p_prefix, final Object p_object, final char p_left_char,
            final char p_right_char)
    {
        StringBuffer sb = new StringBuffer(p_prefix);
        sb.append(SPACE);
        sb.append(quoteIt(p_object, p_left_char, p_right_char));

        return sb.toString();
    }

    /**
     * prefix input string with single quotes (i.e., prefix 'string')
     * 
     * @param p_prefix
     *            is string to prefix string
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in single
     *            quotes
     * @param p_left_char
     *            is character
     * @param p_right_char
     *            is character
     * @param p_newline
     *            is a boolean indicating to append with new line.
     * @return string containing prefix then input string wrapped in quotes
     */
    public final static String quoteIt(final String p_prefix, final Object p_object, final char p_left_char,
            final char p_right_char, final boolean p_newline)
    {
        StringBuffer sb = new StringBuffer(quoteIt(p_prefix, p_object, LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET));
        sb.append(p_newline);
        return sb.toString();
    }

    /**
     * wrap input string with specified left and right char (i.e., prefix
     * [string])
     * 
     * @param p_prefix
     *            is string to prefix string
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in left and
     *            right char
     * @param p_left_char
     *            is character
     * @param p_right_char
     *            is character
     * @return string containing prefix then input string wrapped left and right
     *         char
     */
    public final static String quoteSuffix(final Object p_object, final String p_sufix, final char p_left_char,
            final char p_right_char)
    {
        StringBuffer sb = new StringBuffer(quoteIt(p_object, p_left_char, p_right_char));
        sb.append(SPACE);
        sb.append(p_sufix);

        return sb.toString();
    }

    /**
     * wrap input string with specified left and right char (i.e., prefix
     * [string])
     * 
     * @param p_object
     *            is an object (i.e., String, number) to be wrapped in left and
     *            right char
     * @param p_left_char
     *            is character
     * @param p_right_char
     *            is character
     * @return string containing prefix then input string wrapped left and right
     *         char
     */
    public final static String quoteIt(final Object p_string, final char p_left_char, final char p_right_char)
    {
        String s = EMPTY_STRING;
        try {
            s = p_string.toString();
        }
        catch (NullPointerException e) {
            // do nothing for string is null
        }
        StringBuffer sb = new StringBuffer();
        sb.append(p_left_char);
        sb.append((isPresent(s) ? s : NULL));
        sb.append(p_right_char);

        return sb.toString();
    }

    public final static boolean isPresent(final String p_in)
    {
        return (p_in == null ? true : (p_in.isEmpty() ? true : (p_in.length() < 1 ? true : false)));
    }
}
