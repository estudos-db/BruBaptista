export class Livro {
    private titulo: string;
    private autor: string;
    private emprestado: Boolean;
    
    public constructor (
        titulo: string,
        autor: string) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public getAutor() {
        return this.autor;
    }

    public getTitulo() {
        return this.titulo;
    }
}