package dev.utility.jgui.panels;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import dev.utility.jgui.base.TextAreaCreator;




public class ConsolePanel extends TextAreaCreator  {


	private static final long serialVersionUID = 1L;
	PrintStream consoleStream; 
	Console console; 
	Boolean divertOutput;
	
	
	public ConsolePanel( ) throws IOException
	{       
		super("Terminal Window" ,"Read only",10,20,false);
		console = new Console(textArea);
		consoleStream = new PrintStream(console);
	System.setOut(consoleStream);
	System.setErr(consoleStream);
	
	}
	
	public JPanel getPanel()
	{
		return getPanel(); 
	}
	

	class Console extends OutputStream {
		private final ByteArrayOutputStream buf = new ByteArrayOutputStream();
		private final JTextArea textArea;

		public Console(JTextArea consoleOutput) throws IOException {
			super();
			this.textArea = consoleOutput;
		}

		@Override
		public void flush() throws IOException {

			this.textArea.append(buf.toString("UTF-8"));
			buf.reset();
		}

		@Override
		public void write(int b) throws IOException {

			buf.write(b);
		}

	}


}
