# TheLordOfTheRings-TerminalGame-Java


# compilación

si estoy ubicado en la carpeta raiz del **proyecto** debo moverme a la carpeta src, sería la raíz de mi código

```bash
cd src
```

Una vez en la carpeta raiz de mí código, es decir dentro de src ya puedo compilar

```bash
javac -d ../build org/ipc1/tlotr/util/*.java org/ipc1/tlotr/character/*.java org/ipc1/tlotr/character/beasts/*.java org/ipc1/tlotr/character/heroes/*.java org/ipc1/tlotr/*.java
```

# Ejecutar
Si estoy en la carpeta raíz de mi código, es decir dentro de la carpeta src, debo regresar a la carpeta raiz de mi proyecto

```bash
cd ..
```

una vez allí puedo ejecutar 

```bash
java -cp ./build/ org.ipc1.tlotr.Main
```
