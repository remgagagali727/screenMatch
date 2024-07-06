package principa;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.NoValueException;
import modelos.Titulo;
import modelos.TituloOMDB;
import online.BuscarPelicula;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscarPelicula buscar = new BuscarPelicula();
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        List<Titulo> titulos = new ArrayList<>();

        while(true) {
            System.out.println("Escribe el nombre de la pelicula a buscar:");

            String busqueda = lectura.nextLine();

            if(busqueda.equalsIgnoreCase("salir")) break;

            String json = buscar.buscarPelicula(URLEncoder.encode(busqueda));

            System.out.println(json);

            TituloOMDB miTituloOMBD = gson.fromJson(json, TituloOMDB.class);
            try {
                Titulo miTitulo = new Titulo(miTituloOMBD);
                System.out.println("Titulo ya convertido : " + miTitulo);

                titulos.add(miTitulo);
            } catch (NoValueException e ){
                System.out.println("Ocurrio un error:");
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);
        FileWriter fw = new FileWriter("peliculas.json");
        fw.write(gson.toJson(titulos));
        fw.close();
        System.out.println("Finalizo la ejecucion del programa");
    }
}