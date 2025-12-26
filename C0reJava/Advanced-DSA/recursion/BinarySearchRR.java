class BSRR{
    public static void main(String ...args){
        int[] paglu = {1,2,3,4,5,6,7,8,9,55,66,77,88,99,100};
        IO.println(search(paglu, 100, 0, paglu.length - 1));
    }

    static int search(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int mid = s + (e - s) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(target < arr[mid]){
            return search(arr, target, s, mid - 1);
        }
        return search(arr, target, mid + 1, e);
    }
}