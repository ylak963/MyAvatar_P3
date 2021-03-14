package es.studium.myavatar;

public interface OnNuevoDialogoListener
{
    // propagar un evento que se produzca en el diálogo, que sea capturado en la actividad principal

    //Método para mostrar los diálogos
    public void onDialogoMostrarSexo();
    public void onDialogoMostrarEspecie();
    public void onDialogoMostrarProfesion();

    //Método para recoger los datos de los diálogos
    public void onDataSetDialogNombre(String nombre);
    public void onDataSetDialogSexo(String sexo);
    public void onDataSetDialogEspecie(String especie);
    public void onDataSetDialogProfesion(String profesion);

    //Método para generar de forma aleatoria los poderes de los avatares
    public void randomPoderes();

}
