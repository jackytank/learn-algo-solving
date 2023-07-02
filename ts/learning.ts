interface Vehicle {
    topSpeed: number;
}

interface Train extends Vehicle {
    type: 'Train',
    carriages: number;
}

interface Plane extends Vehicle {
    type: 'Plane',
    wingSpan: number;
}

type PlanOrTrain = Plane | Train;

function getSpeedRatio(v: PlanOrTrain) {
    if (v.type === 'Train') {
        return v.topSpeed / v.carriages;
    }
    return v.topSpeed / v.wingSpan;
}