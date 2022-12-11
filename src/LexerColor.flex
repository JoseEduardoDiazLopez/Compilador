import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColor
%type TextColor
%char
%{
    private TextColor textColor(long start, int size, Color color){
        return new TextColor((int) start, size, color);
    }
%}
/* Variables básicas de comentarios y espacios */
TerminadorDeLinea = \r|\n|\r\n
EntradaDeCaracter = [^\r\n]
EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
ContenidoComentario = ( [^*] | \*+ [^/*] )*
ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

/* Comentario */
Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

/* Identificador */
Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
Digito = [0-9]
A=[!¡]
Identificador = {Letra}({Letra}|{Digito})*
P=[.]
/* Número */
Numero = 0 | [1-9][0-9]*
%%

/* Comentarios o espacios en blanco */
{Comentario} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }
{EspacioEnBlanco} { /*Ignorar*/ }

/* ------------------------------------------------------------ */
/* IDENTIFICADOR*/
@{Identificador} { return textColor(yychar, yylength(), new Color(53, 255, 249)); }
/* TIPOS DE DATO */
C |
CAD |
SZ |
Z |
R |
Q |
D | 
VOF { return textColor(yychar, yylength(), new Color(255, 198, 6)); }

/* NUMERO*/
 0 | [1-9][0-9]* { return textColor(yychar, yylength(), new Color(255, 255, 255)); }

/*COLORES*/
BLANCO |
GRISCLARO |
GRIS |
NEGRO |
ROJO |
ROSA |
NARANJA |
AMARILLO |
VERDE |
FUSCIA |
AZULTURQ |
AZUL { return textColor(yychar, yylength(), new Color(116, 254, 1)); }

/*OPERADORES DE AGRUPACION*/
"<(" |
")>" { return textColor(yychar, yylength(), new Color(255, 255, 255)); }


/*OPERADORES */
EQU |
MAS |
MENOS |
POR |
ENTRE |
Y |
O |
DIF |
MAY |
MEN |
MAS1 |
MEN1 { return textColor(yychar, yylength(), new Color(116, 254, 1)); }

/*PUNTUACION */
"!!" { return textColor(yychar, yylength(), new Color(200, 70, 255)); }

/*PALABRAS RESERVADAS*/

Cond |
Conds |
Mientras  |
Ciclar  |
Hacer  |
Este |
Devolver |
CHANGE |
v |
f { return textColor(yychar, yylength(), new Color(255, 198, 6)); }

/* FUNCION */
{Letra}({Letra}|{Digito})*"()" { return textColor(yychar, yylength(), new Color(188, 254, 94)); }

/*ERRORES*/ 

/*identificador no valido*/
@{Numero}{Letra}* { return textColor(yychar, yylength(), new Color(255, 5, 5)); }
/*numero no valido*/
0{Numero}* { return textColor(yychar, yylength(), new Color(255, 5, 5)); }

. { return textColor(yychar, yylength(), new Color(255, 255, 255)); }