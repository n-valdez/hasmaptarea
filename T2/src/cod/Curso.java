package cod;

import java.util.Comparator;

public class Curso {


    enum Dias {
        L(1), M(2), X(3), J(4), V(5);
        private final int orden;

        Dias(int orden) {
            this.orden = orden;
        }

        public int getOrden() {
            return orden;
        }
    }

    enum Turnos {
        M(1), T(2), N(3);
        private final int orden;

        Turnos(int orden) {
            this.orden = orden;
        }

        public int getOrden() {
            return orden;
        }
    }

    public static final Comparator<Curso> ORDEN_COD_FACULTAD = (o1, o2) -> {
        if (Integer.parseInt(o1.codFacultad) > Integer.parseInt(o2.getCodFacultad())) {
            return 1;
        }

        if (Integer.parseInt(o1.codFacultad) < Integer.parseInt(o2.getCodFacultad())) {
            return -1;
        }

        return 0;
    };

    public static final Comparator<Curso> ORDEN_DIA_TURNO = (o1, o2) -> {
        int comparador = 0;
        if (Dias.valueOf(o1.getDia()).getOrden() > Dias.valueOf(o2.getDia()).getOrden()) {
            comparador = 1;
        }

        if (Dias.valueOf(o1.getDia()).getOrden() < Dias.valueOf(o2.getDia()).getOrden()) {
            comparador = -1;
        }
        if (comparador == 0) {
            if (Turnos.valueOf(o1.getTurno()).getOrden() > Turnos.valueOf(o2.getTurno()).getOrden()) {
                comparador = 1;
            }
        }
        return comparador;
    };

    public static final String[] DIAS_VALIDACION = {"L", "M", "X", "J", "V"};
    public static final String[] TURNOS_VALIDACION = {"M", "T", "N"};
    public static final String[] ESTADO_CURSO_VALIDACION = {"A", "I", "B"};


    private String codFacultad;
    private String nroCurso;
    private String nombreMateria;
    private String dia;
    private String turno;
    private int nroAula;
    private String estadoCurso;

    public Curso() {
        super();
    }

    public Curso(String codFacultad, String nroCurso, String nombreMateria, String dia, String turno, int nroAula,
                 String estadoCurso) {
        super();
        this.codFacultad = codFacultad;
        this.nroCurso = nroCurso;
        this.nombreMateria = nombreMateria;
        this.dia = dia;
        this.turno = turno;
        this.nroAula = nroAula;
        this.estadoCurso = estadoCurso;
    }

    public String getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getNroCurso() {
        return nroCurso;
    }

    public void setNroCurso(String nroCurso) {
        this.nroCurso = nroCurso;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNroAula() {
        return nroAula;
    }

    public void setNroAula(int nroAula) {
        this.nroAula = nroAula;
    }

    public String getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(String estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    @Override
    public String toString() {
        return "Curso [codFacultad=" + codFacultad +
                ", nroCurso=" + nroCurso +
                ", nombreMateria=" + nombreMateria
                + ", dia=" + dia +
                ", turno=" + turno +
                ", nroAula=" + nroAula +
                ", estadoCurso=" + estadoCurso + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.parseInt(codFacultad);
        result = prime * result + Integer.parseInt(nroCurso);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Curso other = (Curso) obj;
        if (!codFacultad.equalsIgnoreCase(other.codFacultad))
            return false;
        if (!nroCurso.equalsIgnoreCase(other.nroCurso))
            return false;
        return true;
    }


}
