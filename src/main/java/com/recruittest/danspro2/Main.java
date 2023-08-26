package com.recruittest.danspro2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("DansProTest2 is running...");
		
		Gson googleJson = new Gson();
		
		HttpClient klienHttp = HttpClient.newHttpClient();
		HttpRequest getRequest;
		boolean loop = true;
		
		while (loop == true) {

			System.out.print("\nChoose your action:"
					+ "\n1) Show whole API http://dev3.dansmultipro.co.id/api/recruitment/positions.json"
					+ "\n2) Choose API data with specific ID http://dev3.dansmultipro.co.id/api/recruitment/positions/{ID}"
					+ "\nYour choosen action: ");
			
			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();
			System.out.println("Your choice: " + choice);
			
			if (choice.equals("1")) {

				getRequest = HttpRequest.newBuilder().uri(new URI("http://dev3.dansmultipro.co.id/api/recruitment/positions.json")).build();
				
				HttpResponse<String> getResponse = klienHttp.send(getRequest, BodyHandlers.ofString());
				System.out.println("\nJSON CONTENT:\n" + getResponse.body());
			} else if (choice.equals("2")) {
				System.out.print("Enter ID: ");
				String id = input.nextLine();
				
				getRequest = HttpRequest.newBuilder().uri(new URI("http://dev3.dansmultipro.co.id/api/recruitment/positions/" + id)).build();
				
				HttpResponse<String> getResponse = klienHttp.send(getRequest, BodyHandlers.ofString());
				System.out.println("\nJSON CONTENT:\n" + getResponse.body());
			} else {
				System.out.println("Choice '" + choice + "' is unavailable");
			}
		}
	}
}
