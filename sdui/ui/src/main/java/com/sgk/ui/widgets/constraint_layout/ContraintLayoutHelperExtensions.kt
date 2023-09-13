package com.sgk.ui.widgets.constraint_layout

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.Dimension


fun List<ConstrainedLayoutReference>.getReferenceBasedOnId(id : String) : ConstrainedLayoutReference {
    return this.single { it.id.toString().equals(id, ignoreCase = true) }
}

fun ConstrainScope.checkIfParentElseGetReference(
    list : List<ConstrainedLayoutReference>,
    id : String
): ConstrainedLayoutReference{
    return if (id.equals(com.sgk.ui.widgets.constraint_layout.CONSTRAINT_LAYOUT_PARENT_ID,ignoreCase = true)){
        parent
    } else list.getReferenceBasedOnId(id)
}


fun ConstrainScope.commonConstrainsHandling(
    list : List<ConstrainedLayoutReference>,
    childConstraintModel: com.sgk.model.modal.ChildConstraintModel
){

    childConstraintModel.top?.let {
        val constrainedLayoutReference = checkIfParentElseGetReference(
            list = list,
            id = it.constraintComposableId
        )
        when(it.contraintDirection){
            com.sgk.model.modal.ContraintDirections.TOP -> {
                top.linkTo(
                    constrainedLayoutReference.top,
                    margin = it.margin.dp
                )
            }

            com.sgk.model.modal.ContraintDirections.BOTTOM -> {
                top.linkTo(
                    constrainedLayoutReference.bottom,
                    margin = it.margin.dp
                )
            }
            else -> {}
        }
    }

    childConstraintModel.bottom?.let {
        val constrainedLayoutReference = checkIfParentElseGetReference(
            list = list,
            id = it.constraintComposableId
        )
        when(it.contraintDirection){
            com.sgk.model.modal.ContraintDirections.TOP -> {
                bottom.linkTo(
                    constrainedLayoutReference.top,
                    margin = it.margin.dp
                )
            }

            com.sgk.model.modal.ContraintDirections.BOTTOM -> {
                bottom.linkTo(
                    constrainedLayoutReference.bottom,
                    margin = it.margin.dp
                )
            }
            else -> {}
        }
    }

    childConstraintModel.start?.let {
        val constrainedLayoutReference = checkIfParentElseGetReference(
            list = list,
            id = it.constraintComposableId
        )
        when(it.contraintDirection){
            com.sgk.model.modal.ContraintDirections.START -> {
                start.linkTo(
                    constrainedLayoutReference.start,
                    margin = it.margin.dp
                )
            }

            com.sgk.model.modal.ContraintDirections.END -> {
                start.linkTo(
                    constrainedLayoutReference.end,
                    margin = it.margin.dp
                )
            }
            else -> {}
        }
    }

    childConstraintModel.end?.let {
        val constrainedLayoutReference = checkIfParentElseGetReference(
            list = list,
            id = it.constraintComposableId
        )
        when(it.contraintDirection){
            com.sgk.model.modal.ContraintDirections.START -> {
                end.linkTo(
                    constrainedLayoutReference.start,
                    margin = it.margin.dp
                )
            }

            com.sgk.model.modal.ContraintDirections.END -> {
                end.linkTo(
                    constrainedLayoutReference.end,
                    margin = it.margin.dp
                )
            }
            else -> {}
        }
    }


    childConstraintModel.width_constraint?.let {
        width = it.getDimenssion()
    }

    childConstraintModel.height_constraint?.let {
        height = it.getDimenssion()
    }

}

fun com.sgk.model.modal.ContraintHeightWidth.getDimenssion() : Dimension{
    return  when(this){
        com.sgk.model.modal.ContraintHeightWidth.WRAP_CONTENT -> Dimension.wrapContent
        com.sgk.model.modal.ContraintHeightWidth.MATCH_PARENT -> Dimension.matchParent
        com.sgk.model.modal.ContraintHeightWidth.FILL_TO_CONSTRAINTS -> Dimension.fillToConstraints
    }
}