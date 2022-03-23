package com.ti2cc;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		int resp;
		Scanner sc = new Scanner(System.in);
		
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		
		System.out.println("1-Listar\n2-Inserir\n3-Excluir\n4-Atualizar\n5-Sair");
		System.out.println("Digite uma opção: ");
		resp = sc.nextInt();

		while(true) {
			
			switch (resp){
				case 1: 
					//Mostrar usuários
					usuarios = dao.getUsuarios();
					System.out.println("==== Mostrar usuários === ");		
					for(int i = 0; i < usuarios.length; i++) {
						System.out.println(usuarios[i].toString());
					}
					break;
					
				case 2: 
					//Inserir um elemento na tabela
					if(dao.inserirUsuario(usuario) == true) {
						System.out.println("Inserção com sucesso -> " + usuario.toString());
					}
					break;
					
				case 3:
					//Excluir usuário
					dao.excluirUsuario(usuario.getCodigo());
					break;
					
				case 4: 
					//Atualizar usuário
					usuario.setSenha("nova senha");
					dao.atualizarUsuario(usuario);
					break;
					
				case 5:
					System.exit(1);
					break;
					
				default: 
					System.out.println("Digite um numero valido!"); 
					dao.close();
					break;
			}
		
			resp = sc.nextInt();
		}
	}
}