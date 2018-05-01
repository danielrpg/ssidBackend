package com.ssid.api.apissid.bootstrap;

import com.ssid.api.apissid.domain.*;
import com.ssid.api.apissid.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ActivitiesSsoRepository activitiesSsoRepository;
    private ProgramSsoRepository programSsoRepository;
    private ResourceSsoRepository resourceSsoRepository;
    private TrainersSsoRepository trainersSsoRepository;
    private DepartmentRepository departmentRepository;
    private PositionRepository positionRepository;

    /**
     * Personal assignment Equipment repositories
     **/
    private PersonalRepository personalRepository;
    private EquipamentRepository equipamentRepository;
    private InventoryRepository inventoryRepository;
    private KardexEquipamentRepository kardexEquipamentRepository;
    private AreaRepository areaRepository;

    public DevBootstrap(ActivitiesSsoRepository activitiesSsoRepository, ProgramSsoRepository programSsoRepository,
                        ResourceSsoRepository resourceSsoRepository, TrainersSsoRepository trainersSsoRepository,
                        PersonalRepository personalRepository, EquipamentRepository equipamentRepository,
                        InventoryRepository inventoryRepository, KardexEquipamentRepository kardexEquipamentRepository,
                        AreaRepository areaRepository, DepartmentRepository departmentRepository,
                        PositionRepository positionRepository){
        this.activitiesSsoRepository = activitiesSsoRepository;
        this.programSsoRepository = programSsoRepository;
        this.resourceSsoRepository = resourceSsoRepository;
        this.trainersSsoRepository = trainersSsoRepository;
        this.departmentRepository = departmentRepository;
        this.personalRepository = personalRepository;
        this.equipamentRepository = equipamentRepository;
        this.kardexEquipamentRepository = kardexEquipamentRepository;
        this.inventoryRepository = inventoryRepository;
        this.areaRepository = areaRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(programSsoRepository.count() == 0) {
            //Resources SSO
            ResourceSso resourceSso1 = new ResourceSso();
            resourceSso1.setResourceCost(200.0);
            resourceSso1.setResourceDetail("Hojas tamaño carta");

            ResourceSso resourceSso2 = new ResourceSso();
            resourceSso2.setResourceCost(300.0);
            resourceSso2.setResourceDetail("Pliegos de cartulina");

            ActivitiesSso activitiesSso = new ActivitiesSso();
            activitiesSso.setDetailActivities("Identificar los riesgos a los que estan expuestos los empleados");
            activitiesSso.setDetailGoal("Los empleados identifique por su cuenta los riesgos en sus areas de trabajo");
            activitiesSso.setDetailNumber(20);
            activitiesSso.setDetailTime(Calendar.getInstance().getTime());
            activitiesSso.setDetailType("Capacitación");
            //activitiesSso.getResourceSsos().add(resourceSso1);
            //activitiesSso.getResourceSsos().add(resourceSso2);

            //resourceSso1.setActivitiesSso(activitiesSso);
            //resourceSso2.setActivitiesSso(activitiesSso);

            TrainersSso trainersSso = new TrainersSso();
            trainersSso.setCi("123456789");
            trainersSso.setName("Juan Perez");
            trainersSso.setSkillsDesciprtions("Experto en seguridad industrial");
            trainersSso.setSpecialty("Ing. Industrial");
            //trainersSso.getActivitiesSsos().add(activitiesSso);

            //activitiesSso.setTrainersSso(trainersSso);

            ProgramSso programSso = new ProgramSso();
            programSso.setSsoExecutionTime(Calendar.getInstance().getTime());
            programSso.setSsoGoal("Mejorar los conocimientos de los empleados en seguridad industrial");
            programSso.setSsoIndicator("Mejora en uso de material de seguridad");
            programSso.setSsoObjetive("Capacitar a todos los trabajadores");
            programSso.setSsoResponsable("Pedro Fernandez");
            programSso.setSsoTotalCost(500.50);
            // programSso.getActivitiesSsos().add(activitiesSso);

            //activitiesSso.setProgramSso(programSso);

            this.resourceSsoRepository.save(resourceSso1);
            this.resourceSsoRepository.save(resourceSso2);
            this.activitiesSsoRepository.save(activitiesSso);
            this.trainersSsoRepository.save(trainersSso);
            this.programSsoRepository.save(programSso);

            //Area
            Area area = new Area();
            area.setName("Construccion");
            area.setDescription("Area de Construccion");
            areaRepository.save(area);
            //Personal
            Personal personal = new Personal();
            personal.setArea(area);
            personal.setName("Jhon Doe");
            personal.setAddress("Av. Villazon N° 2326");
            personal.setCellphone("89632548");
            personal.setEmail("jDoe@gmail.com");
            personal.setBirthdate(new GregorianCalendar(1987,05, 15).getTime());
            personal.setActive(true);
            personalRepository.save(personal);

            //Equipment 1
            Equipament equipament1 = new Equipament();
            equipament1.setName("Helmmet");
            equipament1.setType(1);
            equipament1.setDescription("Casco tipo Jokey de ala Ancha");
            equipament1.setImage(new Byte[0]);
            equipamentRepository.save(equipament1);

            //Equipment 2
            Equipament equipament2 = new Equipament();
            equipament2.setName("Electric Drill");
            equipament2.setType(2);
            equipament2.setDescription("Taladro electrico portatil bosch");
            equipament2.setImage(new Byte[0]);
            equipamentRepository.save(equipament2);

            //KardexEquipment
            KardexEquipament kardexEquipament = new KardexEquipament();
            kardexEquipament.setEquipament(equipament2);
            kardexEquipament.setDateKardex(new Date());
            kardexEquipament.setEntryKardex(15);
            kardexEquipament.setOutlayKardex(0);
            kardexEquipament.setBalanceKardex(15);
            kardexEquipamentRepository.save(kardexEquipament);

            //KardexEquipment1
            KardexEquipament kardexEquipament1 = new KardexEquipament();
            kardexEquipament1.setEquipament(equipament2);
            kardexEquipament1.setDateKardex(new Date());
            kardexEquipament1.setEntryKardex(0);
            kardexEquipament1.setOutlayKardex(5);
            kardexEquipament1.setBalanceKardex(10);
            kardexEquipamentRepository.save(kardexEquipament1);

            //InventoryEquipment
            Inventory inventory = new Inventory();
            inventory.setPersonal(personal);
            inventory.setEquipament(equipament2);
            inventory.setDateAsignament(new Date());
            inventory.setStatus("nuevo");
            inventory.setActive(true);
            inventoryRepository.save(inventory);

            //InventoryEquipment1
            Inventory inventory1 = new Inventory();
            inventory1.setPersonal(personal);
            inventory1.setEquipament(equipament1);
            inventory1.setDateAsignament(new Date());
            inventory1.setStatus("nuevo");
            inventory1.setActive(true);
            inventoryRepository.save(inventory1);

        }

        //Organizational structure
        if(departmentRepository.count() == 0){
            Department department1 = new Department();
            department1.setName("Dirección General");
            department1.setDescription("El departamento de dirección general agrupa los cargos relacionados con gerencia.");

            Department department2 = new Department();
            department2.setName("Departamento técnico");
            department2.setDescription("El departamento de dirección general agrupa los cargos relacionados con operaciones.");

            Department department3 = new Department();
            department3.setName("Departamento financiero");
            department3.setDescription("El departamento financiero agrupa los cargos encargados de las finanzas de la empresa.");

            Department department4 = new Department();
            department4.setName("Departamento de recursos humanos");
            department4.setDescription("El departamento de recursos humanos agrupa los cargos encargados del personal.");

            Department department5 = new Department();
            department5.setName("Departamento comercial");
            department5.setDescription("El departamento comercial agrupa los cargos relacionados con las ventas de la empresa.");

            department1 = departmentRepository.save(department1);
            department2 = departmentRepository.save(department2);
            department3 = departmentRepository.save(department3);
            department4 = departmentRepository.save(department4);
            department5 = departmentRepository.save(department5);
        }

        //positions
        if(positionRepository.count() == 0){
            //level 0
            Position position1 = new Position();
            position1.setName("Gerente general");
            position1.setDescription("Gerente general.");
            position1.setLevel(0);
            position1 = positionRepository.save(position1);

            //level 1
            Position position2 = new Position();
            position2.setName("Administrador de obra");
            position2.setDescription("Administrador de obra.");
            position2.setLevel(1);
            position2.setParentPosition(position1);
            position2 = positionRepository.save(position2);

            Position position3 = new Position();
            position3.setName("Jefe de vivienda");
            position3.setDescription("Jefe de vivienda.");
            position3.setLevel(1);
            position3.setParentPosition(position1);
            position3 = positionRepository.save(position3);

            Position position4 = new Position();
            position4.setName("Jefe de administración");
            position4.setDescription("Jefe de administración.");
            position4.setLevel(1);
            position4.setParentPosition(position1);
            position4 = positionRepository.save(position4);

            Position position5 = new Position();
            position5.setName("Jefe de departamento técnico");
            position5.setDescription("Jefe de departamento técnico.");
            position5.setLevel(1);
            position5.setParentPosition(position1);
            position5 = positionRepository.save(position5);

            Position position7 = new Position();
            position7.setName("Asesor contable");
            position7.setDescription("Asesor contable.");
            position7.setLevel(1);
            position7.setParentPosition(position1);
            position7 = positionRepository.save(position7);

            //level 2
            Position position8 = new Position();
            position8.setName("Jefe de obras");
            position8.setDescription("Jefe de obras.");
            position8.setLevel(2);
            position8.setParentPosition(position2);
            position8 = positionRepository.save(position8);

            Position position9 = new Position();
            position9.setName("Capataz");
            position9.setDescription("Capataz.");
            position9.setLevel(2);
            position9.setParentPosition(position2);
            position9 = positionRepository.save(position9);

            Position position10 = new Position();
            position10.setName("Bodeguero de obras");
            position10.setDescription("Bodeguero de obras.");
            position10.setLevel(2);
            position10.setParentPosition(position2);
            position8 = positionRepository.save(position10);

            Position position11 = new Position();
            position11.setName("Operarios");
            position11.setDescription("Operarios.");
            position11.setLevel(2);
            position11.setParentPosition(position2);
            position11 = positionRepository.save(position11);

            Position position12 = new Position();
            position12.setName("Vigilantes");
            position12.setDescription("Vigilantes.");
            position12.setLevel(2);
            position12.setParentPosition(position2);
            position12 = positionRepository.save(position12);

            Position position13 = new Position();
            position13.setName("Secretaria");
            position13.setDescription("Secretaria.");
            position13.setLevel(2);
            position13.setParentPosition(position4);
            position13 = positionRepository.save(position13);

            Position position14 = new Position();
            position14.setName("Mecánico");
            position14.setDescription("Mecánico.");
            position14.setLevel(2);
            position14.setParentPosition(position4);
            position14 = positionRepository.save(position14);

            Position position15 = new Position();
            position15.setName("Operador de maquinaria");
            position15.setDescription("Operador de maquinaria.");
            position15.setLevel(2);
            position15.setParentPosition(position4);
            position15 = positionRepository.save(position15);

            Position position16 = new Position();
            position16.setName("Informático");
            position16.setDescription("Informático.");
            position16.setLevel(2);
            position16.setParentPosition(position4);
            position16 = positionRepository.save(position16);

            Position position17 = new Position();
            position17.setName("Jefe de bodega");
            position17.setDescription("Jefe de bodega.");
            position17.setLevel(2);
            position17.setParentPosition(position4);
            position17 = positionRepository.save(position17);
        }
    }
}
