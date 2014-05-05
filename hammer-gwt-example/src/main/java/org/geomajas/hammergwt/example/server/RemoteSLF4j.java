package org.geomajas.hammergwt.example.server;

import com.google.gwt.logging.server.StackTraceDeobfuscator;
import com.google.gwt.logging.shared.RemoteLoggingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogRecord;

/**
 * @author Dosi Bingov
 */
public class RemoteSLF4j extends RemoteServiceServlet implements
		RemoteLoggingService {
	// No deobfuscator by default
	private static StackTraceDeobfuscator deobfuscator = null;

	private Logger logger = LoggerFactory.getLogger(RemoteSLF4j.class);



	private static String loggerNameOverride = null;

	/**
	 * Logs a Log Record which has been serialized using GWT RPC on the server.
	 * @return either an error message, or null if logging is successful.
	 */
	public final String logOnServer(LogRecord lr) {
		String strongName = getPermutationStrongName();
		/*RemoteLoggingServiceUtil.logOnServer(
				lr, strongName, deobfuscator, loggerNameOverride);*/

		logger.error(lr.getMessage());

		return null;
	}

	/**
	 * By default, messages are logged to a logger that has the same name as
	 * the logger that created them on the client. If you want to log all messages
	 * from the client to a logger with another name, you can set the override
	 * using this method.
	 */
	public void setLoggerNameOverride(String override) {
		loggerNameOverride = override;
	}

	/**
	 * By default, this service does not do any deobfuscation. In order to do
	 * server side deobfuscation, you must copy the symbolMaps files to a
	 * directory visible to the server and set the directory using this method.
	 * @param symbolMapsDir
	 */
	public void setSymbolMapsDirectory(String symbolMapsDir) {
		if (deobfuscator == null) {
			deobfuscator = new StackTraceDeobfuscator(symbolMapsDir);
		} else {
			deobfuscator.setSymbolMapsDirectory(symbolMapsDir);
		}
	}
}