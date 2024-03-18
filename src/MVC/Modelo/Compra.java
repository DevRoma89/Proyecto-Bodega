package MVC.Modelo;

import java.sql.Date;

public class Compra {

    private int IdCompra;
    private Date FechaCompra;
    private int IdUsuario;
    private double TotalCompra;
    private int IdProveedor;
    private int IdDetalleC;
    private int FkIdArticulo;
    private String NombreArticulo;
    private int CantidadArticulo;
    private double PrecioArticulo;
    private double TotalDetalle;

    public Compra() {
    }

    public Compra(int IdCompra, Date FechaCompra, int IdUsuario, double TotalCompra, int IdProveedor, int IdDetalleC, int FkIdArticulo, String NombreArticulo, int CantidadArticulo, double PrecioArticulo, double TotalDetalle) {
        this.IdCompra = IdCompra;
        this.FechaCompra = FechaCompra;
        this.IdUsuario = IdUsuario;
        this.TotalCompra = TotalCompra;
        this.IdProveedor = IdProveedor;
        this.IdDetalleC = IdDetalleC;
        this.FkIdArticulo = FkIdArticulo;
        this.NombreArticulo = NombreArticulo;
        this.CantidadArticulo = CantidadArticulo;
        this.PrecioArticulo = PrecioArticulo;
        this.TotalDetalle = TotalDetalle;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public Date getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(Date FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public double getTotalCompra() {
        return TotalCompra;
    }

    public void setTotalCompra(double TotalCompra) {
        this.TotalCompra = TotalCompra;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public int getIdDetalleC() {
        return IdDetalleC;
    }

    public void setIdDetalleC(int IdDetalleC) {
        this.IdDetalleC = IdDetalleC;
    }

    public int getFkIdArticulo() {
        return FkIdArticulo;
    }

    public void setFkIdArticulo(int FkIdArticulo) {
        this.FkIdArticulo = FkIdArticulo;
    }

    public String getNombreArticulo() {
        return NombreArticulo;
    }

    public void setNombreArticulo(String NombreArticulo) {
        this.NombreArticulo = NombreArticulo;
    }

    public int getCantidadArticulo() {
        return CantidadArticulo;
    }

    public void setCantidadArticulo(int CantidadArticulo) {
        this.CantidadArticulo = CantidadArticulo;
    }

    public double getPrecioArticulo() {
        return PrecioArticulo;
    }

    public void setPrecioArticulo(double PrecioArticulo) {
        this.PrecioArticulo = PrecioArticulo;
    }

    public double getTotalDetalle() {
        return TotalDetalle;
    }

    public void setTotalDetalle(double TotalDetalle) {
        this.TotalDetalle = TotalDetalle;
    }

        
}
