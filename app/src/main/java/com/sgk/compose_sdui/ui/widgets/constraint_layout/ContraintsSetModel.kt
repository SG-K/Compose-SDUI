package com.sgk.compose_sdui.ui.widgets.constraint_layout

import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintSet

fun List<com.sgk.model.modal.ChildConstraintModel>.emptyConstraintSet() : ConstraintSet{
    return ConstraintSet{

    }
}

fun List<com.sgk.model.modal.ChildConstraintModel>.handleContraintsSets() : ConstraintSet{
    return when(this.size){
        0 -> emptyConstraintSet()
//        1 -> singleChildConstraintSet(this)
//        2 -> twoChildConstraintSet(this)
        else -> commonConstraintsSet(this)
    }
}

fun singleChildConstraintSet(
    list : List<com.sgk.model.modal.ChildConstraintModel>
) : ConstraintSet{
    return ConstraintSet{

        val child1 = createRefFor(list[0].refId)

        val constrainedLayoutReferenceList : List<ConstrainedLayoutReference> = listOf(
            child1,
        )

        constrain(child1){
            commonConstrainsHandling(
                constrainedLayoutReferenceList,
                list[0]
            )
        }


    }
}

fun twoChildConstraintSet(
    list : List<com.sgk.model.modal.ChildConstraintModel>
) : ConstraintSet{
    return ConstraintSet{

        val child1 = createRefFor(list[0].refId)
        val child2 = createRefFor(list[1].refId)

        val constrainedLayoutReferenceList : List<ConstrainedLayoutReference> = listOf(
            child1,
            child2
        )

        constrain(child1){
            commonConstrainsHandling(
                constrainedLayoutReferenceList,
                list[0]
            )
        }

        constrain(child2){
            commonConstrainsHandling(
                constrainedLayoutReferenceList,
                list[1]
            )
        }

    }
}

fun commonConstraintsSet(
    list : List<com.sgk.model.modal.ChildConstraintModel>
) : ConstraintSet{
    return ConstraintSet{
        val constrainedLayoutReferencelist: ArrayList<ConstrainedLayoutReference> = ArrayList()
        list.forEach {
            constrainedLayoutReferencelist.add(
                createRefFor(it.refId)
            )
        }

        constrainedLayoutReferencelist.forEachIndexed { index, model ->
            constrain(model) {
                commonConstrainsHandling(
                    constrainedLayoutReferencelist,
                    list[index]
                )
            }
        }

    }
}