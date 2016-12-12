package MiniProjetV1.Server;

import java.io.IOException;
import java.io.PrintWriter;

public class common {
	static final boolean TraceActive = true;
	
	static final int portNumber = 6789;
	static final String addrServer = "127.0.0.1";
	
	public static void affTrace(String mess) {
		if (common.TraceActive)
			System.out.println(mess);
	}
	
	public static void signalErreurToClient(PrintWriter out, String mess) throws IOException {
		affTrace(mess);
		out.println(mess);
	}

}
