import java.util.Date;
public class Persona {

    protected String nombre;
    protected String correo;
    protected int cedula;
    protected long telefono;
    protected Date fechaNacimiento;

    public Persona(String nombre, String correo, int cedula, long telefono, Date fechaNacimiento) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
}
