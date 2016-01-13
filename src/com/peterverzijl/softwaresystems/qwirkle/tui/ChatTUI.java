package com.peterverzijl.softwaresystems.qwirkle.tui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

import com.peterverzijl.softwaresystems.qwirkle.server.Client;
import com.peterverzijl.softwaresystems.qwirkle.ui.ChatView;

public class ChatTUI implements ChatView {
	
	private boolean mRunning = false;
	private Client mClient;
	
	public ChatTUI(String username, InetAddress serverAddress, int serverPort) throws IOException {
		mClient = new Client(username, serverAddress, serverPort, this);
		
		// Start the chat interface.
		run();
	}
	
	/**
	 * Starts the chat TUI
	 */
	public void run() {
		System.out.println("Welcome to the chat!");
		
		// Do the input wait loop
		
		mRunning = true;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Chat: ");
        try {
        	while(mRunning) {
        		String input = br.readLine();
        		if ("\\exit".equals(input)) {
        			close();
        		}      		
        		mClient.sendMessage(input);
        		System.out.println("");
        		System.out.print("Chat: ");
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void close() {
		mRunning = false;	
	}

	@Override
	public void addMessage(String message) {
		System.out.println(message);
	}
}
