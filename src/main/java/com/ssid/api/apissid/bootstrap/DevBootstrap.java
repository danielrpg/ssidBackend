package com.ssid.api.apissid.bootstrap;

import com.ssid.api.apissid.domain.*;
import com.ssid.api.apissid.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ActivitiesSsoRepository activitiesSsoRepository;
    private ProgramSsoRepository programSsoRepository;
    private ResourceSsoRepository resourceSsoRepository;
    private TrainersSsoRepository trainersSsoRepository;
    private DepartmentRepository departmentRepository;

    public DevBootstrap(ActivitiesSsoRepository activitiesSsoRepository, ProgramSsoRepository programSsoRepository,
                        ResourceSsoRepository resourceSsoRepository, TrainersSsoRepository trainersSsoRepository,
                        DepartmentRepository departmentRepository){
        this.activitiesSsoRepository = activitiesSsoRepository;
        this.programSsoRepository = programSsoRepository;
        this.resourceSsoRepository = resourceSsoRepository;
        this.trainersSsoRepository = trainersSsoRepository;
        this.departmentRepository = departmentRepository;
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

            resourceSsoRepository.save(resourceSso1);
            resourceSsoRepository.save(resourceSso2);
            activitiesSsoRepository.save(activitiesSso);
            trainersSsoRepository.save(trainersSso);
            programSsoRepository.save(programSso);
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

            departmentRepository.save(department1);
            departmentRepository.save(department2);
            departmentRepository.save(department3);
            departmentRepository.save(department4);
            departmentRepository.save(department5);
        }


    }
}
