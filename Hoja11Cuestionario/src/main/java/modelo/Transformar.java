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

    public static String valuesOpcion(int id_pregunta, String resp) {
        String sql = null;

        switch (resp) {
            case "resp1":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 1;";
                break;
            case "resp2":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 1,1;";
                break;
            case "resp3":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 2,1;";
                break;
            case "resp4":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 3,1;";
                break;
            case "si":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 1;";
                break;
            case "no":
                sql = "SELECT p_michael , p_dwight , p_jim , p_pam , p_creed , p_kevin , p_andy , p_angela , p_stanley , p_meredith , p_oscar  FROM `preguntas4resp` WHERE id_pregunta = " + id_pregunta + " LIMIT 1,2;";
                break;

            default:
                break;
        }
        return sql;
    }

    public static String insertOption(ArrayList<String> valores) {
        String sql = "INSERT INTO `personajes` (`id`, `michael`, `dwight`, `jim`, `pam`, `creed`, `kevin`, `andy`, `angela`, `stanley`, `meredith`, `oscar`) VALUES (NULL";
        StringBuilder values = new StringBuilder();
        //String values="";
        //  '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0')
        for (int i = 0; i < valores.size(); i++) {
            values.append(", ").append(valores.get(i)).append(" ");
        }
       /* for (int i = 0; i < valores.size(); i++) {
            values=values+(", ")+(valores.get(i))+(" ");
        }*/

        sql = sql + values + ");";
        // System.out.println(sql);

        return sql;
    }

    public static String tipoPregunta(int idPregunta) {

        return "SELECT tipo_pregunta as tipoPregunta from preguntas where id_pregunta=" + idPregunta;
    }
    public static String  eliminarUltimoInsert() {
        return  "DELETE FROM personajes\n" +
                "WHERE id = (\n" +
                "  SELECT id FROM (\n" +
                "    SELECT MAX(id) AS id FROM personajes\n" +
                "  ) AS subquery\n" +
                ");";
    }

    public static String calcularPersonaje() {

        return "select sum(michael) as michael,sum(dwight)as dwight,sum(jim)as jim,sum(pam)as pam,sum(creed)as creed,sum(kevin)as kevin,sum(andy)as andy,sum(angela)as angela,sum(stanley)as stanley,sum(meredith)as meredith,sum(oscar)as oscar from personajes;\n;";


    }
}
