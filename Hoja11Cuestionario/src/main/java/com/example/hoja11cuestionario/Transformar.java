package com.example.hoja11cuestionario;

public class Transformar {

    public static String selectPregunta() {
        String sql;
        sql = "SELECT * FROM preguntas";
        return sql;
    }

    public static String insertPregunta1(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1){

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `"+personaje1+"`) VALUES (NULL, "+id_preguntaV+", '"+respuestaV+"', "+valor1+") ";
        return sql;

    }
    public static String insertPregunta2(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1,String personaje2, int valor2){

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `"+personaje1+"`, `"+personaje2+"`) VALUES (NULL, "+id_preguntaV+", "+respuestaV+", "+valor1+", "+valor2+") ";
        return sql;

    }
    public static String insertPregunta3(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1,String personaje2, int valor2,String personaje3, int valor3){

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `"+personaje1+"`, `"+personaje2+"`, `"+personaje3+"`) VALUES (NULL, "+id_preguntaV+", "+respuestaV+", "+valor1+", "+valor2+", "+valor3+") ";
        return sql;

    }
    public static String insertPregunta4(int id_preguntaV, String preguntaV, String respuestaV,
                                         String personaje1, int valor1,String personaje2, int valor2,String personaje3, int valor3,String personaje4, int valor4){

        String sql;
        sql = "INSERT INTO `preguntas4resp` (`id`, `id_pregunta`, `respuesta`, `"+personaje1+"`, `"+personaje2+"`, `"+personaje3+"`, `"+personaje4+"`) VALUES (NULL, "+id_preguntaV+", "+respuestaV+", "+valor1+", "+valor2+", "+valor3+", "+valor4+") ";
        return sql;

    }

    //CONCHA TU MARE HIUEPUTA


}
