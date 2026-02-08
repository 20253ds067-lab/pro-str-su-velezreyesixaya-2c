public class GradeService {

    public GradeService(){}

    public double promedio_parciales(double cal1,double cal2,double cal3,int asistencia){

        double promedio_par=0;

        promedio_par = (cal1+cal2+cal3)/3;

            if (asistencia>80){
            System.out.println("Tienes la asistencia requerida");
        }else {
            System.out.println("Estas reprobada por asistencias");
        }

        return promedio_par;
    }

    public  double  cali_final(double promedio_par,double asistencia,double calificacion_final){

        calificacion_final =  (promedio_par * 0.7) + (asistencia * 0.3);

            if (calificacion_final>70){
            System.out.println("APROBADO");
        }else {
            System.out.printf("REPROBADO por calificación");
        }

        return promedio_par;
    }

    public boolean entrego_proyecto(boolean entrega_proyecto){
        if (entrega_proyecto == true) {
            System.out.println("Estas aprobado");
        } else {
            System.out.println("Estas reprobado por proyecto");
        }

        return false;
    }
}
