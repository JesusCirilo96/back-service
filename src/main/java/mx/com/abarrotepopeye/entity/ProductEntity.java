package mx.com.abarrotepopeye.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@DynamicUpdate
@Table(name = "producto")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "PRODUCTO_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;

    @Column(name = "NOMBRE")
    private String name;

    @Column(name = "PRECIO")
    private String price;

    @Column(name = "CODIGO_BARRAS")
    private String barCode;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "PK_CATEGORIA")
    private String category;

    @Column(name = "FECHA_CREACION")
    private String createDate;

    @Column(name = "FECHA_ACTUALIZACION")
    private String updateDate;

}
