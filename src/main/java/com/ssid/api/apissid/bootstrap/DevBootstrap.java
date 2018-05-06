package com.ssid.api.apissid.bootstrap;

import com.ssid.api.apissid.domain.*;
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
    private AccidentRepository accidentRepository;
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
                        IncidentRepository incidentRepository,
                        AccidentRepository accidentRepository){
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
        this.accidentRepository = accidentRepository;
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
        loadDataAccidents();

        //loadData
        loadDataAreas();
    }

    private void loadDataAreas() {
        if(areaRepository.count() <= 2){
            Area area1 = new Area();
            area1.setName("Diseño");
            area1.setDescription("Diseños de casas, habitaciones, otros ambientes.");
            areaRepository.save(area1);

            Area area2 = new Area();
            area2.setName("Remodelaciones");
            area2.setDescription("Remodelaciones de ambientes de casas, habitaciones, etc.");
            areaRepository.save(area2);

            Area area3 = new Area();
            area3.setName("Ampliaciones");
            area3.setDescription("Ampliaciones de habitaciones, espacios recreativos, " +
                    "cocinas, areas comunes, etc.");
            areaRepository.save(area3);

            Area area4 = new Area();
            area4.setName("Galpones  y Carpintería metálica");
            area4.setDescription("Trabajos en metal para adaptación de Galpones  y Carpintería metálica" +
                    " para puertas, barandas, otros.");
            areaRepository.save(area4);

            Area area5 = new Area();
            area5.setName("Instalaciones hídricas");
            area5.setDescription("Instalaciones hídricas para ambientes como cocinas, baños, lavandería, " +
                    "duchas, piscinas, jardines, etc.");
            areaRepository.save(area5);

            Area area6 = new Area();
            area6.setName("Instalaciones eléctricas");
            area6.setDescription("Instalaciones eléctricas en los diferentes ambientes donde se trabaje.");
            areaRepository.save(area6);

            Area area7 = new Area();
            area7.setName("Obra gruesa");
            area7.setDescription("Trabajos relacionados a la obra gruesa en la construcción, " +
                    "como ser estructura en las edificaciones, muros, pisos, pavimentos, techado, etc.");
            areaRepository.save(area7);

            Area area8 = new Area();
            area8.setName("Obra fina");
            area8.setDescription("Trabajos relacionados a la obra fina en la construcción, " +
                    "como ser revoque de paredes, cielo raso, cerámica, etc." +
                    " para puertas, barandas, otros.");
            areaRepository.save(area8);
        }
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
        if(equipamentRepository.count()==0) {
            //Area
            Area area = new Area();
            area.setName("Construcción");
            area.setDescription("Construcción de casas, habitaciones, departamentos, etc.");
            areaRepository.save(area);
            //Personal
            Personal personal = new Personal();
            personal.setArea(area);
            personal.setName("Jhon Doe");
            personal.setAddress("Av. Villazon N° 2326");
            personal.setCellphone("89632548");
            personal.setEmail("jDoe@gmail.com");
            personal.setBirthdate(new GregorianCalendar(1987, 05, 15).getTime());
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
            programSso.setSsoExecutionTime("2 semanas");
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

        }

        //positions
        if(positionRepository.count() == 0){
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

            //Colecciones
            Set<Department> departments1 = new HashSet<>();
            departments1.add(department1);

            Set<Department> departments2 = new HashSet<>();
            departments2.add(department2);

            Set<Department> departments3 = new HashSet<>();
            departments3.add(department3);

            Set<Department> departments4 = new HashSet<>();
            departments4.add(department4);

            Set<Department> departments5 = new HashSet<>();
            departments5.add(department5);

            //Positions
            Position position1 = new Position();
            position1.setName("Gerente general");
            position1.setDescription("Gerente general.");
            position1.setLevel(0);
            position1.setDepartments(departments1);

            Set<Position> positionsLst1 = new HashSet<>();
            positionsLst1.add(position1);
            department1.setPositions(positionsLst1);
            departmentRepository.save(department1);
            position1 = positionRepository.save(position1);

            loadDataRequirementsPosition(position1);
            loadDataFunctionsPosition(position1);

            //level 1
            Position position2 = new Position();
            position2.setName("Administrador de obra");
            position2.setDescription("Administrador de obra.");
            position2.setLevel(1);
            position2.setParentPosition(position1);
            position2.setDepartments(departments2);

            Position position8 = new Position();
            position8.setName("Jefe de obras");
            position8.setDescription("Jefe de obras.");
            position8.setLevel(2);
            position8.setParentPosition(position2);
            position8.setDepartments(departments2);

            Position position9 = new Position();
            position9.setName("Capataz");
            position9.setDescription("Capataz.");
            position9.setLevel(2);
            position9.setParentPosition(position2);
            position9.setDepartments(departments2);

            Position position10 = new Position();
            position10.setName("Bodeguero de obras");
            position10.setDescription("Bodeguero de obras.");
            position10.setLevel(2);
            position10.setParentPosition(position2);
            position10.setDepartments(departments2);

            Position position11 = new Position();
            position11.setName("Operarios");
            position11.setDescription("Operarios.");
            position11.setLevel(2);
            position11.setParentPosition(position2);
            position11.setDepartments(departments2);

            Position position12 = new Position();
            position12.setName("Vigilantes");
            position12.setDescription("Vigilantes.");
            position12.setLevel(2);
            position12.setParentPosition(position2);
            position12.setDepartments(departments2);

            Set<Position> positionsLst2 = new HashSet<>();
            positionsLst2.add(position2);
            positionsLst2.add(position8);
            positionsLst2.add(position9);
            positionsLst2.add(position10);
            positionsLst2.add(position11);
            positionsLst2.add(position12);
            department2.setPositions(positionsLst2);

            departmentRepository.save(department2);
            position2 = positionRepository.save(position2);
            position8 = positionRepository.save(position8);
            position9 = positionRepository.save(position9);
            position10 = positionRepository.save(position10);
            position11 = positionRepository.save(position11);
            position12 = positionRepository.save(position12);

            Position position3 = new Position();
            position3.setName("Jefe de vivienda");
            position3.setDescription("Jefe de vivienda.");
            position3.setLevel(1);
            position3.setParentPosition(position1);
            position3.setDepartments(departments5);

            Set<Position> positionsLst5 = new HashSet<Position>();
            positionsLst5.add(position3);
            department5.setPositions(positionsLst5);

            departmentRepository.save(department5);
            position3 = positionRepository.save(position3);

            Position position7 = new Position();
            position7.setName("Asesor contable");
            position7.setDescription("Asesor contable.");
            position7.setLevel(1);
            position7.setParentPosition(position1);
            position7.setDepartments(departments3);

            Set<Position> positionsLst3 = new HashSet<>();
            positionsLst3.add(position7);
            department3.setPositions(positionsLst3);

            departmentRepository.save(department3);
            position7 = positionRepository.save(position7);

            Position position4 = new Position();
            position4.setName("Jefe de administración");
            position4.setDescription("Jefe de administración.");
            position4.setLevel(1);
            position4.setParentPosition(position1);
            position4.setDepartments(departments4);

            Position position5 = new Position();
            position5.setName("Jefe de departamento técnico");
            position5.setDescription("Jefe de departamento técnico.");
            position5.setLevel(1);
            position5.setParentPosition(position1);
            position5.setDepartments(departments4);

            Position position13 = new Position();
            position13.setName("Secretaria");
            position13.setDescription("Secretaria.");
            position13.setLevel(2);
            position13.setParentPosition(position4);
            position13.setDepartments(departments4);

            Position position14 = new Position();
            position14.setName("Mecánico");
            position14.setDescription("Mecánico.");
            position14.setLevel(2);
            position14.setParentPosition(position4);
            position14.setDepartments(departments4);

            Position position15 = new Position();
            position15.setName("Operador de maquinaria");
            position15.setDescription("Operador de maquinaria.");
            position15.setLevel(2);
            position15.setParentPosition(position4);
            position15.setDepartments(departments4);

            Position position16 = new Position();
            position16.setName("Informático");
            position16.setDescription("Informático.");
            position16.setLevel(2);
            position16.setParentPosition(position4);
            position16.setDepartments(departments4);

            Position position17 = new Position();
            position17.setName("Jefe de bodega");
            position17.setDescription("Jefe de bodega.");
            position17.setLevel(2);
            position17.setParentPosition(position4);
            position17.setDepartments(departments4);

            Set<Position> positionsLst4 = new HashSet<>();
            positionsLst4.add(position4);
            positionsLst4.add(position5);
            positionsLst4.add(position13);
            positionsLst4.add(position14);
            positionsLst4.add(position15);
            positionsLst4.add(position16);
            positionsLst4.add(position17);
            department4.setPositions(positionsLst4);

            departmentRepository.save(department4);
            position4 = positionRepository.save(position4);
            position5 = positionRepository.save(position5);
            position13 = positionRepository.save(position13);
            position14 = positionRepository.save(position14);
            position15 = positionRepository.save(position15);
            position16 = positionRepository.save(position16);
            position17 = positionRepository.save(position17);
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

        FunctionPosition function2 = new FunctionPosition();
        function2.setName("Formulación de Proyectos");
        function2.setDescription("Formulación de proyectos de Ingeniería Civil de alta calidad, resistentes y seguros " +
                "para los usuarios finales");
        function2.setPosition(position1);
        functionPositionRepository.save(function2);

        FunctionPosition function3 = new FunctionPosition();
        function3.setName("Establecer programas");
        function3.setDescription("Establecer programas en la ejecución de obras enfocados al mejor aprovechamiento " +
                "de los recursos");
        function3.setPosition(position1);
        functionPositionRepository.save(function3);
    }

    private void loadDataRequirementsPosition(Position position1) {
        Requirement requirement = new Requirement();
        requirement.setName("Administrador de empresas");
        requirement.setDescription("Titulo en Administrador de empresas");
        requirement.setPosition(position1);
        requirementRepository.save(requirement);

        Requirement requirement1 = new Requirement();
        requirement1.setName("Formación académica");
        requirement1.setDescription("Formación académica en Administrador de empresas");
        requirement1.setPosition(position1);
        requirementRepository.save(requirement1);

        Requirement requirement2 = new Requirement();
        requirement2.setName("Experiencia");
        requirement2.setDescription("Más de 3 años de experiencia  en cargos similares de Jefatura dentro el área de " +
                "mantenimiento, fiscalización de obras y administración de proyectos.");
        requirement2.setPosition(position1);
        requirementRepository.save(requirement2);
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
    private void loadDataAccidents() {
        if (accidentRepository.count() == 0) {
            String[] lugares = new String[10];
            lugares[0] = "HOSPITAL ANOCARAIRE – VINTO BOLIVIA";
            lugares[1] = "HOSPITAL UNIVALLE";
            lugares[2] = "HOSPITAL HARRY WILLIAMS";
            lugares[3] = "HOSPITAL SAN VICENTE DE PAUL";
            lugares[4] = "EMERGENCIAS HOSPITAL VIEDMA";
            lugares[5] = "CAJA INTEGRAL CORDES";
            lugares[6] = "CAJA DE SALUD DE LA BANCA PRIVADA";
            lugares[7] = "CAJA PETROLERA DE SALUD – ADMINISTRACIÓN DEPARTAMENTAL COCHABAMBA";
            lugares[8] = "CAJA PETROLERA DE SALUD – HOSPITAL ELIZABETH SETON";
            lugares[9] = "CENTRO MEDICO QUIR. BOLIVIANO BELGA S.R.L.";

            String[] nombres = new String[10];
            nombres[0] = "Isaac Newton";
            nombres[1] = "Cristóbal Colón";
            nombres[2] = "Albert Einstein";
            nombres[3] = "Louis Pasteur";
            nombres[4] = "James Watt";
            nombres[5] = "Adam Smith";
            nombres[6] = "Ernest Rutherford";
            nombres[7] = "Thomas Jefferson";
            nombres[8] = "Zoroastro";
            nombres[9] = "Carlomagno";







            int max = 8;
            int min = 0;
            int range = (max - min) + 1;

            for (int i=0; i<100; i++){
                Accident accident = new Accident();
                int nm =  (int)(Math.random() * range) + min;
                accident.setPersonal(nombres[nm]);

                accident.setDateAt(new Date());

                int bm =  (int)(Math.random() * range) + min;
                accident.setBajamedica((long) bm);

                int lg = (int)(Math.random() * range) + min;
                accident.setLugaratencion(lugares[lg]);
                accident.setDescription("Leccion en la espalda al tropezar");

                accident.setReportBy("Jorge Churme");
                accident.setInjuryForm("Caida a nivel");
                accident.setInjuryType("Heridas cortantes");
                accident.setInjuryBody("Region craneana");
                accident.setCausingAgent("Piso");
                accident.setAccidentType("Accidente de personal");

                accidentRepository.save(accident);

            }
        }
    }
}
