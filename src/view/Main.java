package view;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kill = new KillController();
		
		String processo = "TASKLIST /FO TABLE";
		kill.listaProcesso(processo);
		int pid = 5636;
		kill.mataPID(pid);
		String nome = "notepad.exe";
		kill.mataNome(nome);
		
	}

}
