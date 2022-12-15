public record Contact(String nom, String prenom, String mail) {

    @Override
    public String toString() {
        return this.nom.toUpperCase() + " " + this.prenom + " (" + this.mail + ")";
    }
}