import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class OurArrayListIntegerTest {

    private OurArrayList<Integer> list = new OurArrayList<>();

    @Test
    public void size_Of_Empty_List_Is_0(){

        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void addLast_Adds_Value_To_0_Index_Of_Empty_List_Test(){

        list.addLast(592);

        Assertions.assertThat(list.get(0)).isEqualTo(592);
    }

    /**
     * Add more than INITIAL_CAPACITY elements to the List
     * @result All elements will be added
     */
    @Test
    public void addLast_Increases_Capacity_When_Last_Index_Reached(){

        int numberOfElements = 17;
        addElementsToList(numberOfElements);

        Assertions.assertThat(list.get(16)).isEqualTo(17);
    }

    /**
     * Add 0 as last element
     * @result 0 will be added as last element
     */
    @Test
    public void addLast_Zero_Value_Accepted(){

        list.addLast(0);

        Assertions.assertThat(list.get(0)).isEqualTo(0);
    }

    /**
     * Add an element with addLast
     * @result size incremented by 1
     */
    @Test
    public void addLast_Increments_List_Size(){

        int numberOfElements = 3;

        addElementsToList(numberOfElements);
        int sizeBeforeAddLast = list.size();

        list.addLast(13);

        Assertions.assertThat(list.size()).isEqualTo(sizeBeforeAddLast + 1);
    }

    @Test
    public void get_Index_Out_Of_Bounds_Exception_Thrown_Empty_List(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.get(0); });
    }

    @Test
    public void get_Index_Out_Of_Bounds_Exception_Thrown_Index_More_Than_Size(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.get(16); });
    }

    @Test
    public void get_Index_Out_Of_Bounds_Exception_Thrown_Index_Less_Than_Zero(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.get(-1); });
    }

    @Test
    public void get_By_First_Index(){

        addElementsToList(5);

        int value = list.get(0);

        Assertions.assertThat(value).isEqualTo(1);
    }

    @Test
    public void get_By_Last_Index(){

        int numberOfElements = 5;
        addElementsToList(numberOfElements);

        int value = list.get(list.size() - 1);

        Assertions.assertThat(value).isEqualTo(5);
    }

    @Test
    public void get_By_Index_Between_First_And_Last(){

        int numberOfElements = 5;
        addElementsToList(numberOfElements);

        int value = list.get(2);

        Assertions.assertThat(value).isEqualTo(3);
    }


    @Test
    public void set_Index_Out_Of_Bounds_Exception_Thrown_Empty_List(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.set(0, 609); });
    }

    @Test
    public void set_Index_Out_Of_Bounds_Exception_Thrown_Index_More_Than_Size(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.set(16, 17); });
    }

    @Test
    public void set_Index_Out_Of_Bounds_Exception_Thrown_Index_Less_Than_Zero(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.set(-1, 211); });
    }


    @Test
    public void set_To_First_Index(){

        addElementsToList(5);
        list.set(0, 100098);

        Assertions.assertThat(list.get(0)).isEqualTo(100098);
    }

    @Test
    public void set_To_Last_Index(){

        addElementsToList(5);

        list.set(4, 404);

        Assertions.assertThat(list.get(list.size() - 1)).isEqualTo(404);
    }

    @Test
    public void set_To_Index_Between_First_And_Last(){

        int numberOfElements = 20;
        addElementsToList(numberOfElements);

        list.set(17, 30998);

        Assertions.assertThat(list.get(17)).isEqualTo(30998);
    }

    @Test
    public void removeById_Removes_First_Element(){

        addElementsToList(3);

        int valueOfSecondElement = list.get(1);
        list.removeById(0);

        Assertions.assertThat(list.get(0)).isEqualTo(valueOfSecondElement);
    }

    @Test
    public void removeById_Removes_Last_Element(){

        addElementsToList(15);

        int valueOfElementBeforeTheLast = list.get(13);
        list.removeById(14);

        Assertions.assertThat(list.get(list.size() - 1)).isEqualTo(valueOfElementBeforeTheLast);
    }

    @Test
    public void removeById_Removes_Last_Element_In_INITIAL_CAPACITY_Elements_Array(){

        addElementsToList(16);

        int valueOfElementBeforeTheLast = list.get(14);
        list.removeById(15);

        Assertions.assertThat(list.get(list.size() - 1)).isEqualTo(valueOfElementBeforeTheLast);
    }

    @Test
    public void removeById_Removes_Last_Element_In_INITIAL_CAPACITY_Plus_1_Elements_Array(){

        addElementsToList(17);

        int valueOfElementBeforeTheLast = list.get(15);
        list.removeById(16);

        Assertions.assertThat(list.get(list.size() - 1)).isEqualTo(valueOfElementBeforeTheLast);
    }

    @Test
    public void removeById_Reduces_The_Size_By_1(){

        int numberOfElements = 15;

        addElementsToList(numberOfElements);
        list.removeById(2);

        Assertions.assertThat(list.size()).isEqualTo(14);
    }

    @Test
    public void removeById_Returns_Deleted_Value(){

        int numberOfElements = 10;

        addElementsToList(numberOfElements);
        int value = list.removeById(5);

        Assertions.assertThat(value).isEqualTo(6);
    }

    @Test
    public void removeById_Deletes_The_Element(){

        int numberOfElements = 10;

        //addElementsToList adds no duplicated values
        addElementsToList(numberOfElements);
        int value = list.removeById(5);

        Assertions.assertThat(listHasNoValue(value)).isTrue();
    }

    @Test
    public void removeById_Index_Out_Of_Bounds_Exception_Thrown_Empty_List(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.removeById(0); });
    }

    @Test
    public void removeById_Index_Out_Of_Bounds_Exception_Thrown_Index_More_Than_Size(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.removeById(16); });
    }

    @Test
    public void removeById_Index_Out_Of_Bounds_Exception_Thrown_Index_Less_Than_Zero(){

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> { list.removeById(-1); });
    }

    @Test
    public void clear_Sets_Size_To_Zero(){

        addElementsToList(10);
        list.clear();

        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void clear_EmptyList(){

        list.clear();

        Assertions.assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void combined_AddLast_RemoveById_Set_Get_Size_Clear_Test(){
        //{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17}
        addElementsToList(17);

        for (int i = 0; i < list.size(); i++){
                Assertions.assertThat(i + 1).isEqualTo(list.get(i));
        }

        //{1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17}
        list.removeById(2);
        //{1,2,103,5,6,7,8,9,10,11,12,13,14,15,16,17}
        list.set(2, 103);
        //{1,2,103,5,6,7,8,9,10,11,12,13,14,15,16,17,-500}
        list.addLast(-500);
        //{1,2,103,5,6,8,9,10,11,12,13,14,15,16,17,-500}
        list.removeById(5);

        //{1,2,103,5,6,8,9,10,11,12,13,14,15,16,17,-500}
        Assertions.assertThat(1).isEqualTo(list.get(0));
        Assertions.assertThat(2).isEqualTo(list.get(1));
        Assertions.assertThat(103).isEqualTo(list.get(2));
        Assertions.assertThat(5).isEqualTo(list.get(3));
        Assertions.assertThat(6).isEqualTo(list.get(4));
        Assertions.assertThat(8).isEqualTo(list.get(5));
        Assertions.assertThat(9).isEqualTo(list.get(6));
        Assertions.assertThat(10).isEqualTo(list.get(7));
        Assertions.assertThat(11).isEqualTo(list.get(8));
        Assertions.assertThat(12).isEqualTo(list.get(9));
        Assertions.assertThat(13).isEqualTo(list.get(10));
        Assertions.assertThat(14).isEqualTo(list.get(11));
        Assertions.assertThat(15).isEqualTo(list.get(12));
        Assertions.assertThat(16).isEqualTo(list.get(13));
        Assertions.assertThat(17).isEqualTo(list.get(14));
        Assertions.assertThat(-500).isEqualTo(list.get(15));

    }

    /**
     * Adds numberOfElements elements to the List each  with value 'index of an element + 1'
     * @param numberOfElements - number of elements added to the List
     */

    private void addElementsToList(int numberOfElements) {

        int value = 1;
        while (numberOfElements > 0){
            list.addLast(value);
            value++;
            numberOfElements--;
        }

    }

    private boolean listHasNoValue(int value){

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == value) return false;
        }
        return true;
    }

}
