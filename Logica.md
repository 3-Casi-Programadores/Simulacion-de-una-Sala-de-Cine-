# 🎬 Lógica del Proyecto - Simulación de un Cine

## 📌 1. Descripción
**Nombre del Proyecto:** Simulación de Atención en un Cine  
**Fecha de Creación:** 04-03-2025
**Autor(es):** Carlos Campos  
**Versión:** 1.0  

📢 **Resumen:**
Este programa simula la gestión de atención a clientes en un cine. Utiliza una cola de clientes y un sistema de ejecución con múltiples hilos para simular la compra de boletos de manera concurrente.

---

## 🛠 2. Requisitos
📌 **Lenguaje de programación:** Java  
📌 **Versión de Java recomendada:** Java 17  
📌 **Dependencias necesarias:**
- No se requieren librerías externas.  

📌 **Herramientas recomendadas:**
- IDE sugerido: IntelliJ IDEA, VS Code o Eclipse  
- Compilador: `javac`  

---

## 🎭 3. Lógica de Implementación

### **1. Clase `Cine`**
- Contiene una **cola de clientes** (`Queue<String>`) para gestionar el orden de atención.
- Utiliza un **bloque de sincronización (`synchronized`)** para evitar condiciones de carrera entre múltiples hilos.
- Métodos:
  - `agregarCliente(String cliente)`: Agrega un cliente a la cola.
  - `atenderCliente()`: Atiende a los clientes en orden de llegada, simulando el tiempo de espera.

### **2. Clase `SimulacionCine`**
- Es la clase principal del programa.
- Solicita al usuario la **cantidad de clientes** y sus nombres mediante `JOptionPane`.
- Utiliza **`ExecutorService` con un `ThreadPool` de 3 hilos** para atender a los clientes en paralelo.
- Contiene la estructura de control para capturar excepciones y evitar entradas inválidas.

### **3. Flujo del Programa**
1. Se solicita al usuario la cantidad de clientes a atender.
2. Se ingresan los nombres de los clientes (validando que no contengan números ni estén vacíos).
3. Se agregan los clientes a la cola del cine.
4. Se ejecutan **múltiples hilos** que procesan la atención de los clientes.
5. Se muestra un mensaje indicando que el cliente ha comprado su boleto.

---

## ⚙️ 4. Estructura de Datos

### **Clases Principales**  
- `Cine`: Contiene la lógica de la cola de clientes y la simulación de la atención.
- `SimulacionCine`: Ejecuta el programa y maneja la interacción con el usuario.

### **Sincronización**  
- Se utiliza un **bloque `synchronized`** para evitar accesos concurrentes a la cola de clientes.

### **Manejo de Excepciones**  
- Captura errores con `try-catch` al recibir datos de entrada.

---

