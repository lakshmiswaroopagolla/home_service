package com.ty.home_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.home_service.entity.Work;

public interface WorkRepo extends JpaRepository<Work, String> {

}
