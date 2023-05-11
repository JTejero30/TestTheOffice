package modelo;

import java.util.ArrayList;

public class Transformar {


    public static String selectRs4(int idPregunta) {


        String sql = "SELECT pregunta as respuesta from preguntas where id_pregunta=" + idPregunta + " union select respuesta as respuesta from preguntas4resp where id_pregunta = " + idPregunta;


        return sql;
    }

    public static String selectPregunta() {
        String sql;
        sql = "SELECT * FROM preguntas";
        return sql;
    }

    public static String insertPregunta1(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1) {

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `" + personaje1 + "`) VALUES (NULL, " + id_preguntaV + ", '" + respuestaV + "', " + valor1 + ") ";
        return sql;

    }

    public static String insertPregunta2(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1, String personaje2, int valor2) {

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `" + personaje1 + "`, `" + personaje2 + "`) VALUES (NULL, " + id_preguntaV + ", " + respuestaV + ", " + valor1 + ", " + valor2 + ") ";
        return sql;

    }

    public static String insertPregunta3(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1, String personaje2, int valor2, String personaje3, int valor3) {

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `" + personaje1 + "`, `" + personaje2 + "`, `" + personaje3 + "`) VALUES (NULL, " + id_preguntaV + ", " + respuestaV + ", " + valor1 + ", " + valor2 + ", " + valor3 + ") ";
        return sql;

    }

    public static String insertPregunta4(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1, String personaje2, int valor2, String personaje3, int valor3, String personaje4, int valor4) {

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `" + personaje1 + "`, `" + personaje2 + "`, `" + personaje3 + "`, `" + personaje4 + "`) VALUES (NULL, " + id_preguntaV + ", " + respuestaV + ", " + valor1 + ", " + valor2 + ", " + valor3 + ", " + valor4 + ") ";
        return sql;

    }

    public static String valuesOpcion(int id_pregunta, boolean opcion) {
        String sql;

        if (opcion) {
            sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 1;";
        } else {
            sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta= " + id_pregunta + " LIMIT 1,2;";
        }
        return sql;
    }

    public static String insertOption(ArrayList<String> valores) {
        String sql = "INSERT INTO `personajes` (`id`, `michael`, `dwight`, `jim`, `pam`, `creed`, `kevin`, `andy`, `angela`, `stanley`, `meredith`, `oscar`) VALUES (NULL";
        StringBuilder values = new StringBuilder();
        // '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')
        for (int i = 0; i < valores.size(); i++) {
            values.append(", ").append(valores.get(i)).append(" ");
        }
        sql = sql + values + ");";
       // System.out.println(sql);

        return sql;
    }


}
