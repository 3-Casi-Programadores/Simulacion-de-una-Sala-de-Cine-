import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;

class Cine {
    private final Queue<String> colaClientes = new LinkedList<>();
    private final Object lock = new Object();
    
    // Método para agregar clientes a la cola
    public void agregarCliente(String cliente) {
        synchronized (lock) {
            colaClientes.add(cliente);
            JOptionPane.showMessageDialog(null, cliente + " ha llegado a la cola.");
        }
    }
    
    // Método para atender a los clientes
    public void atenderCliente() {
        synchronized (lock) {
            if (!colaClientes.isEmpty()) {
                String cliente = colaClientes.poll();
                JOptionPane.showMessageDialog(null, "Atendiendo a " + cliente);
                try {
                    Thread.sleep(2000); // Simula el tiempo de atención
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    JOptionPane.showMessageDialog(null, "Error en la atención: " + e.getMessage());
                }
                JOptionPane.showMessageDialog(null, cliente + " ha comprado su boleto.");
            } else {
                JOptionPane.showMessageDialog(null, "No hay clientes en la cola.");
            }
        }
    }
}

public class SimulacionCine {
    public static void main(String[] args) {
        Cine cine = new Cine();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        try {
            int cantidadClientes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clientes:"));
            for (int i = 0; i < cantidadClientes; i++) {
                String nombreCliente;
                do {
                    nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente " + (i + 1) + ":");
                    if (nombreCliente == null || nombreCliente.trim().isEmpty() || nombreCliente.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "Nombre no válido, no debe contener números. Intente de nuevo.");
                    }
                } while (nombreCliente == null || nombreCliente.trim().isEmpty() || nombreCliente.matches(".*\\d.*"));
                
                cine.agregarCliente(nombreCliente);
            }
            
            for (int i = 0; i < cantidadClientes; i++) {
                executor.execute(cine::atenderCliente);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido.");
        } finally {
            executor.shutdown();
        }
    }
}
