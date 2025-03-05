// librerias necesarias para la ejecución del programa.
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
// cine es una clase que simula la atención de clientes en un cine.
class Cine {
    // Cola de clientes, implementada con una LinkedList (cola).
    // Qyueue es una interfaz, LinkedList es una clase que implementa la interfaz Queue
    // lock es un objeto que se usa para sincronizar el acceso a la cola de clientes
    private final Queue<String> colaClientes = new LinkedList<>();
    private final Object lock = new Object();
    
    // Método para agregar clientes a la cola
    public void agregarCliente(String cliente) {
        synchronized (lock) {
            // Se agrega el cliente a la cola.
            colaClientes.add(cliente);
            JOptionPane.showMessageDialog(null, cliente + " ha llegado a la cola.");
        }
    }
    
    // Método para atender a los clientes
    public void atenderCliente() {
        // Se sincroniza el acceso a la cola de clientes, para evitar condiciones de carrera entre hilos.
        synchronized (lock) {
            // Se verifica si hay clientes en la cola.
            if (!colaClientes.isEmpty()) {
                String cliente = colaClientes.poll();
                JOptionPane.showMessageDialog(null, "Atendiendo a " + cliente);
                // Se simula el tiempo de atención, 2 segundos. 
                try {
                    // Se duerme el hilo por 2 segundos.
                    Thread.sleep(2000); // Simula el tiempo de atención
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    // En caso de que ocurra un error en la atención.
                    JOptionPane.showMessageDialog(null, "Error en la atención: " + e.getMessage());
                }
                JOptionPane.showMessageDialog(null, cliente + " ha comprado su boleto.");
            } else {
                JOptionPane.showMessageDialog(null, "No hay clientes en la cola.");
            }
        }
    }
}

// Clase principal que simula la atención de clientes en un cine.
public class SimulacionCine {
    public static void main(String[] args) {
       // Se crea una instancia de la clase Cine 
        Cine cine = new Cine();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Se solicita al usuario la cantidad de clientes
        try {
            int cantidadClientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clientes:"));
           // Se solicita al usuario el nombre de cada cliente y se agrega a la cola
            for (int i = 0; i < cantidadClientes; i++) {
                // Se solicita el nombre del cliente.
                String nombreCliente;
                // Se valida que el nombre no sea nulo, vacío o contenga números.
                do {
                    nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente " + (i + 1) + ":");
                    if (nombreCliente == null || nombreCliente.trim().isEmpty() || nombreCliente.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "Nombre no válido, no debe contener números. Intente de nuevo.");
                    }
                } while (nombreCliente == null || nombreCliente.trim().isEmpty() || nombreCliente.matches(".*\\d.*"));
                
                cine.agregarCliente(nombreCliente);
            }
            // Se ejecutan los hilos para atender a los clientes
            for (int i = 0; i < cantidadClientes; i++) {
                executor.execute(cine::atenderCliente);
            }
            // Se cierra el ExecutorService
        } catch (NumberFormatException e) {
            // En caso de que se ingrese un valor no numérico.
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
        } finally {
            // Se cierra el ExecutorService.
            executor.shutdown();
        }
    }
}
