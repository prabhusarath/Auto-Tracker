package io.sarath.repository;

import io.sarath.entity.Data;

public interface WarningsRepository {

    Data create(Data VehicleData, String priority, String alerts);
}
