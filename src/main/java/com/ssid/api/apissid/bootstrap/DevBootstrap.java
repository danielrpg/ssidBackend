package com.ssid.api.apissid.bootstrap;

import com.ssid.api.apissid.domain.*;
import com.ssid.api.apissid.dto.RequestAreaDTO;
import com.ssid.api.apissid.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserSystemRepository userSystemRepository;
    private RoleRepository roleRepository;
    private ActivitiesSsoRepository activitiesSsoRepository;
    private ProgramSsoRepository programSsoRepository;
    private ResourceSsoRepository resourceSsoRepository;
    private TrainersSsoRepository trainersSsoRepository;
    private DepartmentRepository departmentRepository;
    private PositionRepository positionRepository;
    private ContractRepository contractRepository;
    private FunctionPositionRepository functionPositionRepository;
    private RequirementRepository requirementRepository;
    private IncidentTypeRepository incidentTypeRepository;
    private IncidentDetailRepository incidentDetailRepository;
    private IncidentRepository incidentRepository;
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
                        PositionRepository positionRepository,ContractRepository contractRepository,
                        FunctionPositionRepository functionPositionRepository,
                        RequirementRepository requirementRepository,
                        UserSystemRepository userSystemRepository,
                        RoleRepository roleRepository,
                        IncidentTypeRepository incidentTypeRepository,
                        IncidentDetailRepository incidentDetailRepository,
                        IncidentRepository incidentRepository){
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
        this.contractRepository = contractRepository;
        this.functionPositionRepository = functionPositionRepository;
        this.requirementRepository = requirementRepository;
        this.userSystemRepository = userSystemRepository;
        this.roleRepository = roleRepository;
        this.incidentTypeRepository = incidentTypeRepository;
        this.incidentDetailRepository = incidentDetailRepository;
        this.incidentRepository = incidentRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //Cargando los datos iniciales de usuario
        loadDefaulUser();

        //Cargando datos base de estructura organizacional
        loadDataStructureOrganizational();

        //Cargando datos base de SSO
        loadDataSSO();

        //Cargando datos de Inventarios
        loadDataEquipamentInventary();

        //Cargando datos defecto de contratos
        loadDataContracts();

        loadDataIncidents();
    }

    private void loadDefaulUser(){
        Set<Role> listRoles = new HashSet<Role>();
        if(this.roleRepository.count() == 0){
            Role role = new Role();
            role.setRoleName("ROLE_USER");
            role.setVersion(1);
            role.setCreatedOn(new Date());
            this.roleRepository.save(role);
            listRoles.add(role);
            role.setRoleName("ROLE_ADMIN");
            role.setVersion(1);
            role.setCreatedOn(new Date());
            this.roleRepository.save(role);
            listRoles.add(role);
        }
        if(this.userSystemRepository.count() == 0){
            UserSystem userSystem = new UserSystem();
            userSystem.setUsername("admin");
            userSystem.setPassword("$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.");
            userSystem.setUserActive(Boolean.TRUE);
            userSystem.setVersion(1);
            userSystem.setCreatedOn(new Date());
            userSystem.setRoles(listRoles);
            this.userSystemRepository.save(userSystem);
        }


    }

    private void loadDataContracts() {
        //Contract
        if(contractRepository.count() == 0){
            Contract contract = new Contract();
            contract.setCode("001");
            contract.setCity("Cbba");
            contract.setDate(new Date());
            contract.setDescription("Contrato de pasantia universitaria");
            contract.setSalary(1000.0);
            contract.setType("Semestral");

            Contract contract1 = new Contract();
            contract1.setCode("002");
            contract1.setCity("cbba");
            contract1.setDate(new Date());
            contract1.setDescription("contrato para evalucion de personal externo");
            contract1.setSalary(3500.5);
            contract1.setType("Indefinido");

            contract = contractRepository.save(contract);
            contract1 = contractRepository.save(contract1);
        }
    }

    private void loadDataEquipamentInventary() {
        //Area
        Area area = new Area();
        area.setName("Construcción");
        area.setDescription("Area de Construcción");
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

    private void loadDataSSO() {
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
        }
    }

    private void loadDataStructureOrganizational() {
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

            loadDataRequirementsPosition(position1);
            loadDataFunctionsPosition(position1);

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

            //Organizational structure
            if (departmentRepository.count() == 0) {
                Department department1 = new Department();
                department1.setName("Dirección General");
                department1.setDescription("El departamento de dirección general agrupa los cargos relacionados con gerencia.");
//                Set<Position> positionsLst1 = new HashSet<>();
//                positionsLst1.add(position1);
//                department1.setPositions(positionsLst1);

                Department department2 = new Department();
                department2.setName("Departamento técnico");
                department2.setDescription("El departamento de dirección general agrupa los cargos relacionados con operaciones.");
//                Set<Position> positionsLst2 = new HashSet<>();
//                positionsLst2.add(position2);
//                positionsLst2.add(position8);
//                positionsLst2.add(position9);
//                positionsLst2.add(position10);
//                positionsLst2.add(position11);
//                positionsLst2.add(position12);
//                department2.setPositions(positionsLst2);

                Department department3 = new Department();
                department3.setName("Departamento financiero");
                department3.setDescription("El departamento financiero agrupa los cargos encargados de las finanzas de la empresa.");
//                Set<Position> positionsLst3 = new HashSet<>();
//                positionsLst3.add(position7);
//                department3.setPositions(positionsLst3);

                Department department4 = new Department();
                department4.setName("Departamento de recursos humanos");
                department4.setDescription("El departamento de recursos humanos agrupa los cargos encargados del personal.");
//                Set<Position> positionsLst4 = new HashSet<>();
//                positionsLst4.add(position4);
//                positionsLst4.add(position5);
//                positionsLst4.add(position13);
//                positionsLst4.add(position14);
//                positionsLst4.add(position15);
//                positionsLst4.add(position16);
//                positionsLst4.add(position17);
//                department4.setPositions(positionsLst4);

                Department department5 = new Department();
                department5.setName("Departamento comercial");
                department5.setDescription("El departamento comercial agrupa los cargos relacionados con las ventas de la empresa.");
//                Set<Position> positionsLst5 = new HashSet<>();
//                positionsLst5.add(position3);
//                department5.setPositions(positionsLst5);

                departmentRepository.save(department1);
                departmentRepository.save(department2);
                departmentRepository.save(department3);
                departmentRepository.save(department4);
                departmentRepository.save(department5);
            }
        }
    }

    private void loadDataFunctionsPosition(Position position1) {
        FunctionPosition function = new FunctionPosition();
        function.setName("Genenciar la empresa");
        function.setDescription("Debe encargarse de Genenciar la empresa de la mejor manera posible");
        function.setPosition(position1);
        functionPositionRepository.save(function);

        FunctionPosition function1 = new FunctionPosition();
        function1.setName("Administración de recursos");
        function1.setDescription("Debe encargarse de la Administración de todos los recursos de la empresa");
        function1.setPosition(position1);
        functionPositionRepository.save(function1);

        //Function datos
//        if(functionRepository.count() == 0){
//            Function function = new Function();
//            function.setName("Formulación de Proyectos");
//            function.setDescription(" Formulación de proyectos de Ingeniería Civil de alta calidad, resistentes y seguros para los usuarios finales");
//
//            Function function1 = new Function();
//            function1.setName("Establecer procedimientos ");
//            function1.setDescription("  Establecer procedimientos para la operación de equipo y maquinaria para obtener la mejor calidad y productividad, teniendo en cuenta la protección del medio ambiente");
//
//            Function function2 = new Function();
//            function2.setName("Adiestrar al personal  ");
//            function2.setDescription("Adiestrar al personal dentro de una obra, desde los operativos, en el uso y manejo de los materiales y en la operación de la maquinaria y equipo de construcción");
//
//            Function function3 = new Function();
//            function3.setName("Establecer programas");
//            function3.setDescription("Establecer programas en la ejecución de obras enfocados al mejor aprovechamiento de los recursos");
//
//            function = functionRepository.save(function);
//            function1 = functionRepository.save(function1);
//            function2 = functionRepository.save(function2);
//            function3 = functionRepository.save(function3);
//        }
    }

    private void loadDataRequirementsPosition(Position position1) {
        Requirement requirement = new Requirement();
        requirement.setName("Administrador de empresas");
        requirement.setDescription("Titulo en Administrador de empresas");
        requirement.setPosition(position1);
        requirementRepository.save(requirement);

        Requirement requirement1 = new Requirement();
        requirement1.setName("Administrador de empresas");
        requirement1.setDescription("Titulo en Administrador de empresas");
        requirement1.setPosition(position1);
        requirementRepository.save(requirement1);

        //Requirement
//        if(requirementRepository.count() == 0){
//            Requirement requirement = new Requirement();
//            requirement.setName("Formación académica");
//            requirement.setDescription("Formación académica en Ingeniería Civil o Arquitectura.");
//
//            Requirement requirement1 = new Requirement();
//            requirement1.setName("Se valorará conocimientos  ");
//            requirement1.setDescription("Se valorará conocimientos de energía eléctrica y mantenimiento en general.");
//
//            Requirement requirement2 = new Requirement();
//            requirement2.setName("Experiencia ");
//            requirement2.setDescription("Experiencia mínima de 3 años en cargos similares de Jefatura dentro el área de mantenimiento, fiscalización de obras y administración de proyectos");
//
//            Requirement requirement3 = new Requirement();
//            requirement3.setName("manejo de programas ");
//            requirement3.setDescription(" Excelente manejo de programas como ser: AutoCAD, PRESCOM, ArchiCAD, Project, CYPE");
//
//            requirement = requirementRepository.save(requirement);
//            requirement1 = requirementRepository.save(requirement1);
//            requirement2 = requirementRepository.save(requirement2);
//            requirement3 = requirementRepository.save(requirement3);
//        }
    }

    private void loadDataIncidents() {
        if(incidentTypeRepository.count() == 0) {
            IncidentType incidentType = new IncidentType();
            incidentType.setIncidentTypeDescription("Este es el registro de accidentes");
            incidentType.setIncidentTypeName("accidente");
            incidentType.setIncidentSubType("");

            IncidentType incidentType1 = new IncidentType();
            incidentType1.setIncidentTypeDescription("Enfermedad muy contagiosa");
            incidentType1.setIncidentTypeName("enfermedad");
            incidentType1.setIncidentSubType("gripe");

            IncidentType incidentType2 = new IncidentType();
            incidentType2.setIncidentTypeDescription("Perdida de material");
            incidentType2.setIncidentTypeName("incidente");
            incidentType2.setIncidentSubType("");

            IncidentDetail incidentDetail = new IncidentDetail();
            incidentDetail.setIncidentDetailName("En fecha 02 de Mayo el Ingeniero Perez sufrio un accidente");
            incidentDetail.setIncidentDetailStatus("entregado");
            incidentDetail.setIncidentDetailType("");

            IncidentDetail incidentDetail1 = new IncidentDetail();
            incidentDetail1.setIncidentDetailName("En fecha 02 de Mayo el cortador Gonzales reporto que tenia gripe");
            incidentDetail1.setIncidentDetailStatus("pendiente");
            incidentDetail1.setIncidentDetailType("");

            IncidentDetail incidentDetail2 = new IncidentDetail();
            incidentDetail2.setIncidentDetailName("En fecha 24 de Abril el Licenciado Maldonado reporto que el piso del sector 7 estaba mojado");
            incidentDetail2.setIncidentDetailStatus("reportado");
            incidentDetail2.setIncidentDetailType("");


            Incident incident = new Incident();
            incident.setCode("ACC-01");
            incident.setDateAt(new Date());
            incident.setReportedBy("admin");
            incident.setArea("soldadura");
            incident.setReincident(false);
            incident.setTreatment(false);
            incident.setIncidentType(incidentType);
            incident.setIncidentDetail(incidentDetail);

            Incident incident1 = new Incident();
            incident1.setCode("ENF-01");
            incident1.setDateAt(new Date());
            incident1.setReportedBy("admin");
            incident1.setArea("mecanica");
            incident1.setReincident(false);
            incident1.setTreatment(false);
            incident1.setIncidentType(incidentType1);
            incident1.setIncidentDetail(incidentDetail1);

            Incident incident2 = new Incident();
            incident2.setCode("INC-01");
            incident2.setDateAt(new Date());
            incident2.setReportedBy("admin");
            incident2.setArea("finanzas");
            incident2.setReincident(false);
            incident2.setTreatment(false);
            incident2.setIncidentType(incidentType2);
            incident2.setIncidentDetail(incidentDetail2);

            incidentTypeRepository.save(incidentType);
            incidentTypeRepository.save(incidentType1);
            incidentTypeRepository.save(incidentType2);

//            incidentDetailRepository.save(incidentDetail);
//            incidentDetailRepository.save(incidentDetail1);
//            incidentDetailRepository.save(incidentDetail2);
//
            incidentRepository.save(incident);
            incidentRepository.save(incident1);
            incidentRepository.save(incident2);
        }
    }
}
