package com.ssid.api.apissid.domain;

import com.fasterxml.jackson.annotation.*;
//import javassist.bytecode.ByteArray;
//import sun.security.util.BitArray;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "equipaments")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_getAllEquipament",
                procedureName = "sp_get_all_equipament",
                resultClasses = Equipament.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_createEquipament",
                procedureName = "sp_create_equipament",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_type", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_image", type = Byte[].class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_equipamentById",
                procedureName = "sp_get_all_equipament",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_id", type = Long.class)
                },
                resultClasses = Equipament.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_editEquipament",
                procedureName = "sp_edit_equipament",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_type", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_description", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_image", type = Byte[].class)
                },
                resultClasses = Equipament.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_deleteEquipament",
                procedureName = "sp_delete_equipament",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "equipament_id", type = Long.class)
                }
        )
})
public class Equipament extends ModelBase implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "equipament_id")
    private Long id;

    @Column(name = "equipament_name", length = 200)
    private String name;

    @Column(name = "equipament_description", length = 200)
    private String description;

    @Column(name = "equipament_type", length = 50)
    private Integer type;

    @Lob
    @Column(name = "equipament_image")
    private Byte[] image;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "equipament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<KardexEquipament> kardexEquipaments;

    @JsonIgnore
    @OneToMany(mappedBy = "equipament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Inventory> inventories;

//    @OneToOne
//    private AssignEquipament assignEquipament;

//    public AssignEquipament getAssignEquipament() {
//        return assignEquipament;
//    }
//
//    public void setAssignEquipament(AssignEquipament assignEquipament) {
//        this.assignEquipament = assignEquipament;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Set<KardexEquipament> getKardexEquipaments() {
        return kardexEquipaments;
    }

    public void setKardexEquipaments(Set<KardexEquipament> kardexEquipaments) {
        this.kardexEquipaments = kardexEquipaments;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

}
