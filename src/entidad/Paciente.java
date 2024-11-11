package entidad;

public class Paciente {
    private int dni;
    private String nombre;
    private int edad;
    private char sexo;
    private double[] altura;
    private double[] peso;


    public Paciente(int dni, String nombre, int edad, char sexo, double[] altura, double[] peso) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public Paciente() {

    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double[] getPeso() {
        return peso;
    }

    public void setPeso(double[] peso) {
        this.peso = peso;
    }

    public int menorPeso (){//30,65,80,99
        int mes = 0;
        double min = this.peso[0];

        for (int i = 1; i < this.peso.length;i++) {
            if (peso[i]< min) {
                min = peso [i];
                mes = i;
            }
        }
        return mes;
    }

    public double imc (int mes, double altura){

        if (mes < 0 || mes >= this.peso.length) {
            throw new IllegalArgumentException("Mes fuera de rango.");
        }
        return this.peso[mes] / (altura * altura);
    }

    public int[] menosDeXKilos(double x){
        int count = 0;
        for (double p : this.peso) {
            if (peso < x) count++;
        }
        if (count == 0) return null;

        int[] meses = new int[count];
        int index = 0;
        for (int i = 0; i < this.peso.length; i++) {
            if (this.peso[i] < x) {
                meses[index++] = i;
            }
        }
        return meses;
    }



    public String pesoMesX(int mes, double altura) {
        double imc = imc(mes, altura);

        if (imc < 18.5) {
            return "bajo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "sobrepeso";
        } else {
            return "obeso";
        }
    }
