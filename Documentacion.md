# 📘 Documentación del Proyecto - Simulación de un Cine

## 📌 1. Descripción  
**Nombre del Proyecto:** Simulador de Cine  
**Fecha de Creación:** [DD/MM/AAAA]  
**Autor(es):** [Nombre del encargado]  
**Versión:** 1.0  

📢 **Resumen:**  
Este proyecto simula la operación de un cine permitiendo a los usuarios comprar boletos, seleccionar asientos, ver cartelera y gestionar funciones. Además, implementa un sistema de atención de clientes en la taquilla mediante una cola de espera con concurrencia para agilizar el proceso de compra de boletos.

---

## 🛠 2. Requisitos  
📌 **Lenguaje de programación:** Java  
📌 **Versión de Java recomendada:** Java 17  
📌 **Dependencias necesarias:**  
- No se requieren dependencias externas.  

📌 **Herramientas recomendadas:**  
- IDE sugerido: [VS Code]  
- Compilador: `javac`  

---

## 🎭 3. Funcionalidades

1. **Mostrar cartelera:** Lista las películas disponibles y sus horarios.  
2. **Seleccionar función:** Permite al usuario elegir una película y horario.  
3. **Comprar boletos:** Registra la compra de boletos y permite seleccionar asientos.  
4. **Mostrar asientos disponibles:** Representa la sala con asientos ocupados y libres.  
5. **Cancelar reservación:** Permite liberar asientos reservados.  
6. **Gestión de clientes en taquilla:** Manejo de una cola de espera con atención concurrente.  

---

## 🧑‍💻 4. Lógica de Implementación

1. **Gestor de Cartelera:**
   - Almacena la información de las películas y horarios disponibles.  

2. **Sistema de Reservaciones:**
   - Gestiona la disponibilidad de asientos en cada función.  
   - Permite seleccionar y reservar asientos.  
   
3. **Procesamiento de Pagos:**
   - Simula la compra de boletos.  

4. **Atención de Clientes en Taquilla:**
   - Implementa una cola (`Queue<String>`) para gestionar clientes en espera.  
   - Usa `ExecutorService` con un grupo de hilos (`FixedThreadPool`) para procesar múltiples clientes de manera concurrente.  
   - Simula el tiempo de atención mediante `Thread.sleep()`.  

---

## ⚙️ 5. Estructura de Datos

### **Clases Principales**  
- `Cine`: Maneja la cartelera y las funciones. También administra la cola de clientes en la taquilla.  
- `Pelicula`: Almacena información sobre cada película.  
- `Funcion`: Representa una función específica de una película.  
- `Sala`: Administra los asientos y disponibilidad.  
- `Usuario`: Representa a un cliente que compra boletos.  
- `SimulacionCine`: Clase principal que ejecuta el flujo del programa, incluyendo la atención de clientes en cola.  

---

## 🔧 6. Mejoras Futuras

- **Implementar Base de Datos:** Guardar información de clientes y funciones.  
- **Interfaz Gráfica (GUI):** Crear una aplicación visual en JavaFX o Swing.  
- **Métodos de Pago:** Integración con plataformas de pago.  
- **Optimización del Sistema de Cola:** Implementar un sistema más eficiente de atención con prioridad.  

---

## 📚 7. Conclusiones

Este simulador de cine proporciona una experiencia interactiva para la compra de boletos y selección de funciones. La implementación de una cola de clientes con atención concurrente mejora la eficiencia del sistema y permite atender múltiples usuarios al mismo tiempo, brindando una experiencia más realista y fluida.
