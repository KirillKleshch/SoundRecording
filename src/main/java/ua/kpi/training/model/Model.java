package ua.kpi.training.model;

import ua.kpi.training.model.composition.Composition;
import ua.kpi.training.view.DefaultMessages;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kirill on 02.05.2017.
 */
public class Model {
    Disk disk = new Disk(110);

    public void writeOnDisk(int number) throws LowDiskStorageException {
        if (new CreateComposition().createComposition(number).getSize() + calculateTotalSize(disk.getListOfComposition()) < disk.getMaxSize()) {
            disk.getListOfComposition().add(new CreateComposition().createComposition(number));
        } else {
            throw new LowDiskStorageException(DefaultMessages.LOW_MEMORY_EXCEPTION);
        }
    }

    public List<Composition> sortByStyle(List<Composition> listOfComposition) {
        Collections.sort(listOfComposition,
                (composition1, composition2) ->
                        composition1.getStyle()
                                .compareTo(composition2.getStyle()));
        return listOfComposition;
    }

    public List<Composition> selectedSongDesiredDuration(List<Composition> listOfComposition, Integer[] duration) {
        disk.setMinDuration(duration[0]);
        disk.setMaxDuration(duration[1]);
        listOfComposition = listOfComposition.stream()
                .filter(Disk::moreMinDuration)
                .filter(Disk::lessMaxDuration)
                .sorted((composition1, composition2) ->
                        ((Integer) composition1.getDuration())
                                .compareTo((Integer) (composition2.getDuration())))
                .collect(Collectors.toList());
        return listOfComposition;
    }

    public Integer calculateTotalSize(List<Composition> compositionList) {
        Integer totalSize = 0;
        for (Composition composition : compositionList) {
            totalSize += composition.getSize();
        }
        return totalSize;
    }

    public List<Composition> getList() {
        return disk.getListOfComposition();
    }
}
