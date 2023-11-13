package com.example.base

import com.example.util.BaseResponse

interface BaseUseCase<in I, R : Any> {
    suspend operator fun invoke(input: I): BaseResponse<R>
}
