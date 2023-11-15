package mx.com.abarrotepopeye.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@DynamicUpdate
@Table(name = "categoria")
public class CategoryEntity implements Serializable {

    @Id
    @Column(name = "CATEGORIA_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "NOMBRE_CATEGORIA")
    private String name;

    @Column(name = "ESTADO")
    private String status;

    @Column(name = "FECHA_CREACION")
    private String createDate;

    @Column(name = "FECHA_ACTUALIZACION")
    private String updateDate;

}
