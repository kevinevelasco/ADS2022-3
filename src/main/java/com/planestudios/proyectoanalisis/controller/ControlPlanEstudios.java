package com.planestudios.proyectoanalisis.controller;

import com.planestudios.proyectoanalisis.model.PlanEstudios;

public class ControlPlanEstudios {
    private PlanEstudios planEstudios;
    public ControlPlanEstudios(PlanEstudios planEstudios){
        this.planEstudios = planEstudios;
    }
    public PlanEstudios getPlanEstudios() {
        return this.planEstudios;
    }
}
