package com.example.demo;

import com.example.demo.entity.UsuariosEntity;
import com.example.demo.services.IUsuarioService;
import com.example.demo.services.UsuarioService;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

@SpringBootApplication
public class EjemploApplication implements CommandLineRunner {
	@Autowired
	private IUsuarioService usuarioService;

	String nl= System.lineSeparator();

    public static void main(String[] args) {

		System.out.println("Iniciando la aplicacion");
		SpringApplication.run(EjemploApplication.class, args);
		System.out.println("Finalizando la aplicacion");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Aplicacion Emprendimiento");
		emprendimientoApp();
	}

	private void emprendimientoApp() {
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			var opcion = mostrarMenu();
			salir=ejecutarOpciones(consola,opcion );
		}
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir =false;
		switch (opcion){
			case 1 -> {
				System.out.println("************Listado usuarios***************");
				List<UsuariosEntity> usuarios = usuarioService.listarUsuarios();
				usuarios.forEach(usuario -> System.out.print(usuario.toString()+nl));
			}
			case 2 ->{
				System.out.println("************Agregar usuarios***************"+nl);
				System.out.println("Identificacion: "+nl);
				var identificacion= consola.nextLine();
				System.out.println("Nombre: "+nl);
				var nombre= consola.nextLine();
				System.out.println("Genero: "+nl);
				var genero= consola.nextLine();
				System.out.println("Edad: "+nl);
				var edad= Integer.parseInt(consola.nextLine());
				System.out.println("Ciudad: "+nl);
				var ciudad= consola.nextLine();
				var usuario= new UsuariosEntity();
				usuario.setIdentificacion(identificacion);
				usuario.setNombre(nombre);
				usuario.setGenero(genero);
				usuario.setEdad(edad);
				usuario.setCiudad(ciudad);

				usuarioService.insertarUsuario(usuario);
				System.out.println("El usuario ha sido agregado"+nl);
			}
			/*case 3->{
				System.out.println("************Actualizar usuarios***************");
				System.out.println("Identificacion");
				var id= Integer.parseInt(consola.nextLine());
				var usu=
				UsuariosEntity usuario = usuarioService.actualizarUsuarios(id,);
				if(usuario!= null){
					System.out.println("Nombre");
					var nombre= consola.nextLine();
					System.out.println("Genero: "+nl);
					var genero= consola.nextLine();
					System.out.println("Edad: "+nl);
					var edad= Integer.parseInt(consola.nextLine());
					System.out.println("Ciudad: "+nl);
					var ciudad= consola.nextLine();
					//
					usuario.setNombre(nombre);
					usuario.setGenero(genero);
					usuario.setEdad(edad);
					usuario.setCiudad(ciudad);
					usuarioService.insertarUsuario(usuario);
					System.out.println("Usuario modificado   "+ usuario+nl);
				}
			else System.out.println("usuario no encontrado"+nl);
			}
				case 4->{
					System.out.println("*****************Eliminar usuario**********************");
					System.out.println("Identificacion");
					var idusuario=Integer.parseInt(consola.nextLine());
					var usuario= usuarioService.actualizarUsuarios(idusuario);
					if (usuario!= null){
						usuarioService.eliminarUsuario(usuario);
						System.out.println("Usuario eliminado "+nl+ usuario+ nl);
					}else
						System.out.println("Usuario no encontrado"+ usuario+nl);
				}*/
				case  5-> {
					System.out.println("Hasta pronto "+ nl+nl);
					salir=true;
				}
			default -> System.out.println("Opcion no reconocida"+ opcion+nl);

		}
        return salir;
    }

	private int mostrarMenu() {
		System.out.print("****" +nl+
				"1. Listar usuarios" +nl+
				"2. Agregar usuarios" +nl+
				"3. Modificar usuarios" +nl+
				"4. Eliminar usuarios" +nl+
				"5. Salir" +nl+
				"Elige una opcion");
		var consola = new Scanner(System.in);
		var i = Integer.parseInt(consola.nextLine());
		return i;
	}

}
