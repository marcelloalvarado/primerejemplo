package AlmacenadoPlataforma3D.ConeccionBD;
public class validarRut {    
    
public boolean valr(String rut) {
 
    boolean validacion = false;
try {
rut =  rut.toUpperCase();
rut = rut.replace(".", "");
rut = rut.replace("-", "");
int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));//toma los valores menos el verificador
 
char dv = rut.charAt(rut.length() - 1);//toma el digito verificador
 
int m = 0, s = 1;
for (; rutAux != 0; rutAux /= 10) {
s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
}
if (dv == (char) (s != 0 ? s + 47 : 75)) {
validacion = true;
}
 
} catch (java.lang.NumberFormatException e) {
} catch (Exception e) {
}
return validacion;
}
}
