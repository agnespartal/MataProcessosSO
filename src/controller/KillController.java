package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcesso(String processo) {
		String so = os();
		if (so.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String line = buffer.readLine();
				while (line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		} if (so.contains("Linux")) {
			processo = "ps -ef";
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String line = buffer.readLine();
				while (line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mataPID (int pid) {
		String so = os();
		if (so.contains("Windows")) {
			String cmdPID = "TASKKILL /PID";
			StringBuffer buffer = new StringBuffer();			
			
			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(pid);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}if (so.contains("Linux")) {
			String cmdPID = "kill -9 pid_do_processo";
			StringBuffer buffer = new StringBuffer();			
			
			try {
				buffer.append(cmdPID);
				buffer.append(" ");
				buffer.append(pid);
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mataNome(String nome) {
		String so = os();
		if (so.contains("Windows")) {
			String cmdNome = "TASKKILL /IM";
			StringBuffer buffer = new StringBuffer();			
			
			try {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(nome);
			} catch(Exception e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}if (so.contains("Linux")) {
			String cmdNome = "pkill -f nome_do_processo";
			StringBuffer buffer = new StringBuffer();			
			
			try {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(nome);
			} catch(Exception e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
