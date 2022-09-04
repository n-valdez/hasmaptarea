package cod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import static cod.Curso.*;

public class OperacionesCursoHashMap {
    private final HashMap<String, Curso> mapaCursos = new HashMap<>();
    private final Queue<Curso> colaCursosOrdFacultad = new PriorityQueue<>(Curso.ORDEN_COD_FACULTAD);
    private final Queue<Curso> colaCursosOrdDiaTurno = new PriorityQueue<>(Curso.ORDEN_DIA_TURNO);

    private final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public void Menu() throws IOException {

        int opcion = 0;

        while (opcion != 6) {

            System.out.println("Selecione una opcion");
            System.out.println("1- Agregar Curso");
            System.out.println("2- Mostrar cursos ordenados por cod. facultad desc");
            System.out.println("3- Modificar Curso");
            System.out.println("4- Eliminar Curso");
            System.out.println("5- Mostrar cursos ordenados por dia y turno asc");
            System.out.println("6- Salir");

            System.out.println("Ingrese una opcion:");


            try {
                opcion = Integer.parseInt(entrada.readLine());
            } catch (Exception e) {
                System.out.println("Opcion incorrecta");
                //ignored
            }

            switch (opcion) {
                case 1:
                    agregarCurso();
                    break;
                case 2:
                    cursosOrdCodigoFacultad();
                    break;
                case 3:
                    modificarCurso();
                    break;
                case 4:
                    eliminarCurso();
                    break;
                case 5:
                    cursosOrdPorDiaTurno();
                    break;
                case 6:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }

        }

    }

    private void agregarCurso() throws IOException {
        Curso cursoNuevo = new Curso();
        String diaTemp = "";
        String turnoTemp = "";
        String estadoTemp = "";

        System.out.println("Ingrese codigo de la facultad");
        cursoNuevo.setCodFacultad(entrada.readLine());

        System.out.println("Ingrese numero de curso");
        cursoNuevo.setNroCurso(entrada.readLine());

        System.out.println("Ingrese nombre de la materia");
        cursoNuevo.setNombreMateria(entrada.readLine());


        while (!checkEntradaValida(DIAS_VALIDACION, diaTemp)) {
            System.out.println("Ingrese el dia (L, M, X, J, V)");
            diaTemp = entrada.readLine().trim();
        }
        cursoNuevo.setDia(diaTemp);

        while (!checkEntradaValida(TURNOS_VALIDACION, turnoTemp)) {
            System.out.println("Ingrese el turno  (M=mañana, T=Tarde y N=Noche)");
            turnoTemp = entrada.readLine().trim();
        }
        cursoNuevo.setTurno(turnoTemp);

        while (!checkEntradaValida(ESTADO_CURSO_VALIDACION, estadoTemp)) {
            System.out.println("Ingrese el estado (A=activo, I=inactivo, B=baja)");
            estadoTemp = entrada.readLine().trim();
        }
        cursoNuevo.setEstadoCurso(estadoTemp);

        if (mapaCursos.containsKey(String.format("%s_%s", cursoNuevo.getCodFacultad(), cursoNuevo.getNroCurso()))) {
            System.out.println("Curso existente, desea sobreescribir los datos (SI/NO)");
            String respuesta = entrada.readLine();
            if (respuesta.equalsIgnoreCase("NO")) {
                return;
            }
        }
        mapaCursos.put(String.format("%s_%s", cursoNuevo.getCodFacultad(), cursoNuevo.getNroCurso()), cursoNuevo);
        System.out.println("Curso agregado");

    }

    private boolean checkEntradaValida(String[] valoresValidos, String valorEntrada) {
        return Arrays.stream(valoresValidos).anyMatch(valor -> valor.equalsIgnoreCase(valorEntrada.trim()));
    }


    private void modificarCurso() {

    }

    private void eliminarCurso() {

    }


    private void cursosOrdCodigoFacultad() {
        if (mapaCursos.isEmpty()) {
            System.out.println("El mapa no contiene productos");
            return;
        }

        for (String codCurso : mapaCursos.keySet()) {
            Curso curso = mapaCursos.get(codCurso);
            colaCursosOrdFacultad.offer(curso);
        }

        int cantidad = colaCursosOrdFacultad.size();
        while (!colaCursosOrdFacultad.isEmpty()) {
            Curso cursoActual = colaCursosOrdFacultad.poll();
            System.out.println(cursoActual.toString());
        }
        System.out.println("Cantidad de cursos: " + cantidad);
        System.out.println();

    }

    private void cursosOrdPorDiaTurno() {
        if (mapaCursos.isEmpty()) {
            System.out.println("El mapa no contiene productos");
            return;
        }

        for (String codCurso : mapaCursos.keySet()) {
            Curso curso = mapaCursos.get(codCurso);
            colaCursosOrdDiaTurno.offer(curso);
        }

        int cantidad = colaCursosOrdDiaTurno.size();
        while (!colaCursosOrdDiaTurno.isEmpty()) {
            Curso cursoActual = colaCursosOrdDiaTurno.poll();
            System.out.println(cursoActual.toString());
        }
        System.out.println("Cantidad de cursos: " + cantidad);
        System.out.println();
    }

}
