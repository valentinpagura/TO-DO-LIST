package to.pkgdo.list;

public class Tarea {
    private String descripcion;
    private boolean hecha;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.hecha = false; // Por defecto, la tarea está "por hacer"
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void marcarComoHecha() {
        this.hecha = true;
    }

    public void marcarComoPorHacer() {
        this.hecha = false;
    }

    @Override
    public String toString() {
        return (hecha ? "[X] " : "[ ] ") + descripcion;
    }
}
